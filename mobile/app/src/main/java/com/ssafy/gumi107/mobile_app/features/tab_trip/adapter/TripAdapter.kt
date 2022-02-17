package com.ssafy.gumi107.mobile_app.features.tab_trip.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.databinding.RcvItemTripBinding
import com.ssafy.gumi107.mobile_app.dto.Flag
import com.ssafy.gumi107.mobile_app.dto.Schedule
import com.ssafy.gumi107.mobile_app.dto.Trip
import com.ssafy.gumi107.mobile_app.service.FlagService
import com.ssafy.gumi107.mobile_app.service.ScheduleService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TripAdapter(private val tripList: MutableList<Trip>) :
    RecyclerView.Adapter<TripAdapter.TripHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
        val binding = RcvItemTripBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TripHolder(binding)
    }

    override fun onBindViewHolder(holder: TripHolder, position: Int) {
        holder.bindInfo(tripList[position])
    }

    override fun getItemCount(): Int = tripList.size

    inner class TripHolder(private val binding: RcvItemTripBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var countryCode: String = ""

        fun bindInfo(trip: Trip) {
            get1stScheduleCountryCode(trip.tripId!!)
            // 1. tripId를 갖고 SelectScheduleByIdAndOrder(tripId, 1)를 한다.
            // 2. SelectScheduleByIdAndOrder(tripId, 1)은 1번째 스케줄을 리턴함.
            // 3. 리턴한 1번째 스케줄의 countryCode를 가져온다.

            // 4. 획득한 countryCode를 여기 bindInfo에 가져온다..?
            // 4. 가져온 countryCode로 해당 국가의 국기 이미지 URL을 찾는다.
            // 5. 이미지뷰에 국기 이미지를 넣는다.
            binding.tripTitle.text = trip.title
            binding.tripDestination.text = "여행지 이름"
            binding.tripPeople.text = "${trip.nowMember} / ${trip.maxMember} 명"
            binding.tripDuration.text =
                "${Global.convertLongToTime(trip.startDate)} ~ ${Global.convertLongToTime(trip.endDate)}"
            itemView.setOnClickListener {
                listener.onClick(trip, layoutPosition)
            }
        }

        private fun get1stScheduleCountryCode(tripId: Long) {
            val ss = ScheduleService()
            ss.selectScheduleByIdAndOrder(tripId, 1, SelectScheduleByIdAndOrderCallback())
        }

        inner class SelectScheduleByIdAndOrderCallback : RetrofitCallback<Schedule> {
            override fun onError(t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
            }

            override fun onSuccess(code: Int, responseData: Schedule) {
                Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
                val imgUrl = getFlag(responseData.countryCode)

            }

            override fun onFailure(code: Int) {
                Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
            }
        }

        private fun getFlag(countryCode: String) {
            val fs = FlagService()
            fs.selectFlag(countryCode, SelectFlagCallback())
        }

        inner class SelectFlagCallback : RetrofitCallback<Flag> {
            override fun onError(t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
            }

            override fun onSuccess(code: Int, responseData: Flag) {
                Log.d(Global.GLOBAL_LOG_TAG, "onSuccess: $responseData")
                Glide.with(binding.tripImage).load(responseData.url).into(binding.tripImage)
            }

            override fun onFailure(code: Int) {
                Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
            }
        }

    }

    interface TripClickListener {
        fun onClick(trip: Trip, position: Int)
    }

    lateinit var listener: TripClickListener
    fun setItemClickListener(listener: TripClickListener) {
        this.listener = listener
    }
}