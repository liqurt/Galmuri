package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripDetailBinding
import com.ssafy.gumi107.mobile_app.config.Constants
import com.ssafy.gumi107.mobile_app.dto.Trip

class TripDetailFragment : BaseFragment<FragmentTripDetailBinding>(
    FragmentTripDetailBinding::bind, R.layout.fragment_trip_detail
) {

    private var trip: Trip? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trip = it.getSerializable("trip") as Trip
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(trip)
    }

    private fun initView(trip: Trip?) {
        if(trip!=null){
            binding.tvTitle.text = trip.title
            binding.tvComment.text = trip.comment
            binding.tvDestination.text = trip.schedule.last().location.locationName
            binding.tvStartDate.text = Constants.convertLongToTime(trip.startDate)
            binding.tvEndDate.text = Constants.convertLongToTime(trip.endDate)
            binding.tvUpdateDate.text = Constants.convertLongToTime(trip.updateDate)
        }else{
            Toast.makeText(this.requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }

}
