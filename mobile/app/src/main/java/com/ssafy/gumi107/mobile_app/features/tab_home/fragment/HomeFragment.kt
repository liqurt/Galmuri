package com.ssafy.gumi107.mobile_app.features.tab_home.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient

import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.databinding.FragmentHomeBinding
import com.ssafy.gumi107.mobile_app.dto.Trip
import com.ssafy.gumi107.mobile_app.dto.UserTrip
import com.ssafy.gumi107.mobile_app.features.tab_trip.adapter.TripAdapter
import com.ssafy.gumi107.mobile_app.service.UserTripService

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::bind, R.layout.fragment_home
) {
    private lateinit var tripAdapter: TripAdapter
    private var tripList = mutableListOf<Trip>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        UserApiClient.instance.me { user, error ->
            binding.greetingMessage.text = "${user?.kakaoAccount?.profile?.nickname}님\n즐거운 여행 되세요!"
            Glide.with(this).load(user?.kakaoAccount?.profile?.profileImageUrl)
                .into(binding.profilePic)

            Log.d(Global.GLOBAL_LOG_TAG, "${user?.kakaoAccount?.email}")
            Log.d(Global.GLOBAL_LOG_TAG, "${
                user?.kakaoAccount?.email?.let {
                    Global.getOnlyIdFromEmail(it)
                }
            }")

            getMyTripList()
        }


    }

    private fun getMyTripList() {
        val userTripService = UserTripService()
        val sampleDomain = "D"
        val sampleUserId = "dummyUserId002"
        userTripService.selectTripsByUserIdAndDomain(sampleUserId,
            sampleDomain,
            SelectTripsByUserIdAndDomainCallback())
    }

    inner class SelectTripsByUserIdAndDomainCallback : RetrofitCallback<List<Trip>> {
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: List<Trip>) {
            Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }


    }


    //152,214,109

    // 투두
    // 1. 메인 액티비티에서 도메인과 유저아이디로 회원가입이 되있는지 체크
    // 2. 되어 있다면, me 는 select. 안 되어 있다면 me는 insert
    //
    // 3. userTrip service중 findByUser를 이용해서 자신이 소속된 트립들을 가져옴
    // 4. 가져온 데이타들을, 시간순으로 재 정렬.
    // 5. 때려박음
}