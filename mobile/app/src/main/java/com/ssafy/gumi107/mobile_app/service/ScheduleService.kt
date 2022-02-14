package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.ssafy.gumi107.mobile_app.api.ScheduleApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.Schedule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScheduleService {
    val onFailureMessage = "연결에 문제 있음"

    fun insertSchedule(schedule: Schedule){
        val call = ApplicationClass.retrofit.create(ScheduleApi::class.java)
        call.insertSchedule(schedule).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertSchedule was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "insertSchedule was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in insertSchedule: $t")
            }
        })
    }

    fun selectScheduleAllByTripId(tripId: Long){
        val call = ApplicationClass.retrofit.create(ScheduleApi::class.java)
        call.selectScheduleAllByTripId(tripId).enqueue(object : Callback<List<Schedule>> {
            override fun onResponse(call: Call<List<Schedule>>, response: Response<List<Schedule>>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectScheduleAllByTripId was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectScheduleAllByTripId was not successful")
                }
            }
            override fun onFailure(call: Call<List<Schedule>>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectScheduleAllByTripId: $t")
            }
        })
    }

    fun selectScheduleByIdAndOrder(tripId: Long, tripOrder: Int){
        val call = ApplicationClass.retrofit.create(ScheduleApi::class.java)
        call.selectScheduleByIdAndOrder(tripId, tripOrder).enqueue(object : Callback<Schedule> {
            override fun onResponse(call: Call<Schedule>, response: Response<Schedule>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectScheduleByIdAndOrder was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectScheduleByIdAndOrder was not successful")
                }
            }
            override fun onFailure(call: Call<Schedule>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectScheduleByIdAndOrder: $t")
            }
        })
    }

    fun updateSchedule(tripId: Long, tripOrder: Int, schedule: Schedule){
        val call = ApplicationClass.retrofit.create(ScheduleApi::class.java)
        call.updateSchedule(tripId, tripOrder, schedule).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateSchedule was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "updateSchedule was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in updateSchedule: $t")
            }
        })
    }

    fun deleteSchedule(tripId: Long, tripOrder : Int){
        val call = ApplicationClass.retrofit.create(ScheduleApi::class.java)
        call.deleteScheduleByIdAndOrder(tripId, tripOrder).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteSchedule was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteSchedule was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in deleteTrip: $t")
            }
        })
    }

}