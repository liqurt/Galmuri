package com.ssafy.gumi107.mobile_app.features.tab_my_page


import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.Global.Companion.me
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.databinding.FragmentProfileBinding
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.service.UserService

class ProfileFragment : BaseFragment<FragmentProfileBinding>(
    FragmentProfileBinding::bind, R.layout.fragment_profile
){
    val PERM_STORAGE = 9
    val REQ_GALLERY = 12

    //선택한 사진을 프로필에 띄우기(아직 안됨)
    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            binding.profileImg.setImageURI(result.data?.data)
            /*if (result.resultCode == Activity.RESULT_OK) {
                when(result) {
                    REQ_GALLERY -> {

                    }
                }
            }*/
        }

    // 뒤로가기 버튼
    private fun Profilegoback(){
        binding.goback.setOnClickListener {
            val action = ProfileFragmentDirections.actionFragmentProfile2ToMypageFragment()
            view?.findNavController()?.navigate(action)
        }
    }

    // 로그아웃 버튼
    private fun ProfileLogout(){
        binding.Logout.setOnClickListener {
            // 로그아웃 처리
        }
    }

    fun RequestPermission(){
        //camera album
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), PERM_STORAGE)
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), PERM_STORAGE)
    }

    fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE
        startActivityForResult(intent, REQ_GALLERY)

    }

    private fun getInfomationAboutMe(me: User?){
        val us = UserService()
        if (me != null) {
            us.selectUser(me,SelectUserCallback())
        }
    }

    private fun initView(){
        Log.d(Global.GLOBAL_LOG_TAG, "initView: $me")
        // 성별
        if(me!!.gender){
            binding.profileRadioMan.isChecked = true
            binding.profileRadioWoman.isChecked = false
        }else{
            binding.profileRadioMan.isChecked = false
            binding.profileRadioWoman.isChecked = true
        }

        // comment - 현재 User에 comment가 없어서 일단 트위터,페북,인스타 주소를 올렸어요
        binding.editTextTextMultiLine.setText(
            "페이스북 : ${me!!.facebook}\n" +
            "인스타그램 : ${me!!.instagram}\n" +
            "트위터 : ${me!!.twitter}"
        )
    }

    inner class SelectUserCallback : RetrofitCallback<User> {
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: User) {
            Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
            me = responseData
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInfomationAboutMe(me)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

        Profilegoback() // 뒤로가기 버튼
        ProfileLogout() // 로그아웃
        //dialog
        binding.tripchoicebtn.setOnClickListener {
            var dialog = CustomDialogFragment()

            dialog.show(childFragmentManager, "customDialog")
        }

        binding.profileImgEdit.setOnClickListener{
            RequestPermission()
            openGallery()
        }

        binding.btnEditProfile.setOnClickListener {
            meUpdate()
            initView()
            val us = UserService()
            us.updateUser(me!!)
        }
    }

    fun meUpdate(){
        if(binding.profileRadioMan.isChecked && !binding.profileRadioWoman.isChecked){
            me!!.gender = true
        }else if(!binding.profileRadioMan.isChecked && binding.profileRadioWoman.isChecked){
            me!!.gender = false
        }
    }
}
