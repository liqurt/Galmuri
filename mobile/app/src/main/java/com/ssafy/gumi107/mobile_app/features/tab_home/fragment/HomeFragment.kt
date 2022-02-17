package com.ssafy.gumi107.mobile_app.features.tab_home.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kakao.sdk.user.UserApiClient

import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.Global.Companion.me
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.databinding.FragmentHomeBinding
import com.ssafy.gumi107.mobile_app.dto.Trip
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
            getMyTripList()
        }


    }

    private fun getMyTripList() {
        val userTripService = UserTripService()
        UserApiClient.instance.me { user, error ->
            user?.kakaoAccount?.email?.let {
                me.userId = Global.getOnlyIdFromEmail(it)
                userTripService.selectTripsByUserIdAndDomain(me.userId,
                    "K",
                    SelectTripsByUserIdAndDomainCallback())
            }
        }
    }

    inner class SelectTripsByUserIdAndDomainCallback : RetrofitCallback<List<Trip>> {
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: List<Trip>) {
            tripList = sortByStartDate(responseData) as MutableList<Trip>

            tripAdapter = TripAdapter(tripList)
            binding.rcvTripListHome.apply {
                adapter = tripAdapter
                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            }
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }

        private fun sortByStartDate(responseData: List<Trip>): List<Trip> {
            return responseData.sortedWith(
                compareBy { it.startDate }
            )
        }
    }
}