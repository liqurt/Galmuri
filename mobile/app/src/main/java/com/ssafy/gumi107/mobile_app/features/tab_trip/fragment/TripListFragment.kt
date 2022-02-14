package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripListBinding
import com.ssafy.gumi107.mobile_app.features.tab_trip.adapter.TripAdapter
import com.ssafy.gumi107.mobile_app.dto.Trip

class TripListFragment : BaseFragment<FragmentTripListBinding>(
    FragmentTripListBinding::bind, R.layout.fragment_trip_list
) {
    private lateinit var tripAdapter: TripAdapter
    private var sampleTripList = mutableListOf<Trip>()

    private fun initTripList() {
        var fakeTrip : Trip
        for (i in 1..10) {
            fakeTrip = Trip(
                comment = "blah",
                done = false,
                endDate = System.currentTimeMillis(),
                maxMember = 4,
                startDate = System.currentTimeMillis(),
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