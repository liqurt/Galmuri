package com.ssafy.gumi107.mobile_app.features.tab_my_page


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.webkit.PermissionRequest
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentProfileBinding
import java.util.jar.Manifest

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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


    }
}
