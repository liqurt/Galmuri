package com.ssafy.gumi107.mobile_app.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ssafy.gumi107.mobile_app.databinding.FragmentTripDetailBinding
import com.ssafy.gumi107.mobile_app.config.Constants
import com.ssafy.gumi107.mobile_app.dto.Trip

class TripDetailFragment : Fragment() {

    private lateinit var binding : FragmentTripDetailBinding
    private var trip: Trip? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trip = it.getSerializable("trip") as Trip
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTripDetailBinding.inflate(inflater, container, false)
        return binding.root
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
