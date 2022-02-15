package com.ssafy.gumi107.mobile_app.features.tab_my_page

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentMypageBinding

class MypageFragment : BaseFragment<FragmentMypageBinding>(
    FragmentMypageBinding::bind, R.layout.fragment_mypage
) {


    private fun gotoProfile(){
        binding.mypageBtn2.setOnClickListener {
            val action = MypageFragmentDirections.actionMypageFragmentToFragmentProfile2()
            view?.findNavController()?.navigate(action)
        }
    }

    private fun gotoFeedback(){
        binding.mypageBtn3.setOnClickListener {
            val action = MypageFragmentDirections.actionMypageFragmentToQnFeedback()
            view?.findNavController()?.navigate(action)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gotoProfile() // go to profile page
        gotoFeedback() // go to Feedback page
    }
}