package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.databinding.FragmentTravelersBinding
import com.ssafy.gumi107.mobile_app.features.tab_trip.adapter.TripAdapter
import com.ssafy.gumi107.mobile_app.dto.Trip
import kotlin.random.Random

class TravelersFragment : Fragment() {
    private lateinit var tripAdapter: TripAdapter
    private var sampleTripList = mutableListOf<Trip>()
    private lateinit var binding: FragmentTravelersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTravelersBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initTripList() {
        var sampleTrip: Trip
        for (i in 1..10) {
            val randomInt: Int = Random(i).nextInt(100)
            sampleTrip =
                Trip((System.currentTimeMillis() + (1000 * 60 * 60 * 24 * i * randomInt))) //Trip의 updateTime을 랜덤하게 설정. 최근순으로 정렬 하려는 것을 보여주기 위하여
            sampleTrip.schedule.sortBy { it.order } // Trip의 생성자에서는 일부러 schedule의 순서를 뒤죽박죽으로 해놨습니다. Trip.schedule.order가 가장 큰 숫자면 '목적지' 로 가정합니다. (DB ERD 참고)
            sampleTripList.add(sampleTrip)
        }
        sampleTripList.sortByDescending { it.updateDate } // 최근순 정렬
    }

    private fun initRecyclerView(view: View) {
        val listener = object : TripAdapter.TripClickListener {
            override fun onClick(trip: Trip, position: Int) {
                val action = TravelersFragmentDirections.actionTabTravelersToTripDetailFragment(trip)
                view.findNavController().navigate(action)
            }
        }
        tripAdapter = TripAdapter(sampleTripList).apply {
            setItemClickListener(listener)
        }
        binding.rcvTrip.apply {
            adapter = tripAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTripList()
        initRecyclerView(view)
    }
}