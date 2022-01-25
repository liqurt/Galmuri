package com.ssafy.gumi107.mobile_app.features.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.databinding.RcvItemTripBinding
import com.ssafy.gumi107.mobile_app.features.config.Constants
import com.ssafy.gumi107.mobile_app.features.dto.Schedule
import com.ssafy.gumi107.mobile_app.features.dto.Trip
import java.text.SimpleDateFormat
import java.util.*

class TripAdapter(private val messageList: MutableList<Trip>)
    : RecyclerView.Adapter<TripAdapter.MessageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripAdapter.MessageHolder {
        val binding = RcvItemTripBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return MessageHolder(binding)
    }

    override fun onBindViewHolder(holder: TripAdapter.MessageHolder, position: Int) {
        holder.bindInfo(messageList[position])
    }

    override fun getItemCount(): Int = messageList.size

    inner class MessageHolder(private val binding: RcvItemTripBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindInfo(trip : Trip) {
            binding.tripTitle.text = trip.title
            binding.tripDestination.text = trip.schedule.last().location.locationName
            binding.tripPeople.text = "${trip.nowMember}/${trip.maxMember}"
            binding.tripDuration.text = "${Constants.convertLongToTime(trip.startDate)} ~ ${Constants.convertLongToTime(trip.endDate)}"
            binding.tripUpdateDate.text = "${Constants.convertLongToTime(trip.updateDate)}"
            itemView.setOnClickListener {
                listener.onClick(trip, layoutPosition)
            }
        }
    }

    interface TripClickListener{
        fun onClick(trip : Trip, position: Int)
    }

    lateinit var listener : TripClickListener
    fun setItemClickListener(listener:TripClickListener){
        this.listener = listener
    }
}