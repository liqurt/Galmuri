package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripMakeBinding

class TripMakeFragment : BaseFragment<FragmentTripMakeBinding>(
    FragmentTripMakeBinding::bind, R.layout.fragment_trip_make
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btInsertTrip.setOnClickListener {
            val action = TripMakeFragmentDirections.actionTripMakeFragmentToTabTravelers()
            view.findNavController().navigate(action)
        }

        binding.btSchedule.setOnClickListener {
            val action = TripMakeFragmentDirections.actionTripMakeFragmentToMapDetailFragment()
            view.findNavController().navigate(action)
        }
    }
}