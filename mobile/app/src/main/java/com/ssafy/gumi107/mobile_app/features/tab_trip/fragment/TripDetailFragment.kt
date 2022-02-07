package com.ssafy.gumi107.mobile_app.features.tab_trip.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripDetailBinding
import com.ssafy.gumi107.mobile_app.config.Global
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
            binding.tvDestination.text = "목적지"
            binding.tvStartDate.text = Global.convertLongToTime(trip.start_date)
            binding.tvEndDate.text = Global.convertLongToTime(trip.end_date)
            binding.tvUpdateDate.text = Global.convertLongToTime(trip.modified_date)
        }else{
            Toast.makeText(this.requireContext(), "Error", Toast.LENGTH_SHORT).show()
        }
    }

}
