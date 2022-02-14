package com.ssafy.gumi107.mobile_app.features.tab_home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient

import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentHomeBinding
import com.ssafy.gumi107.mobile_app.dto.ChatRoom
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.service.UserService

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind, R.layout.fragment_home
) {
    private var User : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            User = it.getSerializable("userInfo") as User
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        UserApiClient.instance.me { user, error ->

            binding.nicknamemsg.text = "닉네임: ${user?.kakaoAccount?.profile?.nickname}"
            var urlprofimeimg = "${user?.kakaoAccount?.profile?.profileImageUrl}"

            Glide.with(this).load(urlprofimeimg).into(binding.imageView3)

        }
        initView(User)
    }
    private fun initView(User: User?) {
        if(User != null){
            UserApiClient.instance.me { user, error ->
                binding.nicknamemsg.text = "닉네임: ${user?.kakaoAccount?.profile?.nickname}"
            }
        }
    }

}