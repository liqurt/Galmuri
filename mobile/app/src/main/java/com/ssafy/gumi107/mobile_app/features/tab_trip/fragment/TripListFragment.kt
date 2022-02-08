package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripListBinding
import com.ssafy.gumi107.mobile_app.features.tab_trip.adapter.TripAdapter
import com.ssafy.gumi107.mobile_app.dto.Trip
import java.time.LocalDateTime
import kotlin.random.Random

class TripListFragment : BaseFragment<FragmentTripListBinding>(
    FragmentTripListBinding::bind, R.layout.fragment_trip_list
) {
    private lateinit var tripAdapter: TripAdapter
    private var sampleTripList = mutableListOf<Trip>()

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initTripList() {
        var fakeTrip : Trip
        for (i in 1..10) {
            val randomInt: Int = Random(i).nextInt(100)
            fakeTrip = Trip(
//                trip_id = randomInt,
//                created_date = System.currentTimeMillis(),
//                modified_date = System.currentTimeMillis(),
                comment = "blah",
                done = false,
                end_date = LocalDateTime.now(),
                max_member = 4,
//                now_member = 2,
                start_date = LocalDateTime.now(),
                theme = "음주가무",
                title = "놀자"
            )
            sampleTripList.add(fakeTrip)
        }
    }

    private fun initRecyclerView(view: View) {
        val listener = object : TripAdapter.TripClickListener {
            override fun onClick(trip: Trip, position: Int) {
                val action = TripListFragmentDirections.actionTabTravelersToTripDetailFragment(trip)
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

    private fun initNewTrip(){
        binding.fabNewTrip.setOnClickListener {
            val action = TripListFragmentDirections.actionTabTravelersToTripMakeFragment()
            view?.findNavController()?.navigate(action)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTripList()
        initRecyclerView(view)
        initNewTrip()
    }
}