package com.ssafy.gumi107.mobile_app.features.tab_trip.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.databinding.RcvItemTripBinding
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.Trip

class TripAdapter(private val tripList: MutableList<Trip>)
    : RecyclerView.Adapter<TripAdapter.TripHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
        val binding = RcvItemTripBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return TripHolder(binding)
    }

    override fun onBindViewHolder(holder: TripHolder, position: Int) {
        holder.bindInfo(tripList[position])
    }

    override fun getItemCount(): Int = tripList.size

    inner class TripHolder(private val binding: RcvItemTripBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindInfo(trip : Trip) {
            binding.tripTitle.text = trip.title
            binding.tripDestination.text = "여행지 이름"
            binding.tripPeople.text = "${trip.now_member}/${trip.max_member}"
//            binding.tripDuration.text = "${Global.convertLongToTime(trip.start_date)} ~ ${Global.convertLongToTime(trip.end_date)}"
//            binding.tripUpdateDate.text = Global.convertLongToTime(trip.modified_date)
            itemView.setOnClickListener {
                listener.onClick(trip, layoutPosition)
            }
        }
    }

    interface TripClickListener{
        fun onClick(trip : Trip, position: Int)
    }

    lateinit var listener : TripClickListener
    fun setItemClickListener(listener: TripClickListener){
        this.listener = listener
    }
}