package com.ssafy.gumi107.mobile_app.features.tab_my_page


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(
    FragmentProfileBinding::bind, R.layout.fragment_profile
){

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Profilegoback() // 뒤로가기 버튼
        ProfileLogout() // 로그아웃
        binding.tripchoicebtn.setOnClickListener {
            var dialog = CustomDialogFragment()

            dialog.show(childFragmentManager, "customDialog")
        }
    }




}
