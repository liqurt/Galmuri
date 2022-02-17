package com.ssafy.gumi107.mobile_app.features.tab_my_page

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentQnFeedbackBinding

class QnFeedback : BaseFragment<FragmentQnFeedbackBinding>(
    FragmentQnFeedbackBinding::bind, R.layout.fragment_qn_feedback
) {

    // 로그아웃 버튼
    private fun QnFLogout(){
        binding.QnFLogout.setOnClickListener {
            // 로그아웃 처리
        }
    }

    // 뒤로가기 버튼
    private fun QnFgoback(){
        binding.QnFgoback.setOnClickListener {
            val action = QnFeedbackDirections.actionQnFeedbackToMypageFragment()
            view?.findNavController()?.navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        QnFLogout() // 로그아웃
        QnFgoback() // 뒤로가기

    }
}