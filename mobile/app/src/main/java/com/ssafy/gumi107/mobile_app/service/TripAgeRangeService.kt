package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.ssafy.gumi107.mobile_app.api.ScheduleApi
import com.ssafy.gumi107.mobile_app.api.TripAgeRangeApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.TripAgeRange
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripAgeRangeService {
    val onFailureMessage = "연결에 문제 있음"

    fun insertTripAgeRange(tripAgeRange: TripAgeRange){
        val call = ApplicationClass.retrofit.create(TripAgeRangeApi::class.java)
        call.insertTripAgeRange(tripAgeRange).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertTripAgeRange was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "insertTripAgeRange was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in insertTripAgeRange: $t")
            }
        })
    }

    fun selectTripAgeRangeByTripId(tripId : Long){
        val call = ApplicationClass.retrofit.create(TripAgeRangeApi::class.java)
        call.selectTripAgeRangeByTripId(tripId).enqueue(object : Callback<List<TripAgeRange>> {
            override fun onResponse(call: Call<List<TripAgeRange>>, response: Response<List<TripAgeRange>>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTripAgeRangeByTripId was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTripAgeRangeByTripId was not successful")
                }
            }
            override fun onFailure(call: Call<List<TripAgeRange>>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectTripAgeRangeByTripId: $t")
            }
        })
    }

    fun selectTripAgeRangeByIdAndAgeRange(tripId: Long, ageRange : Int){
        val call = ApplicationClass.retrofit.create(TripAgeRangeApi::class.java)
        call.selectTripAgeRangeByIdAndAgeRange(tripId, ageRange).enqueue(object : Callback<TripAgeRange> {
            override fun onResponse(call: Call<TripAgeRange>, response: Response<TripAgeRange>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTripAgeRangeByIdAndAgeRange was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTripAgeRangeByIdAndAgeRange was not successful")
                }
            }
            override fun onFailure(call: Call<TripAgeRange>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectTripAgeRangeByIdAndAgeRange: $t")
            }
        })
    }

    //update는 없음

    fun deleteTripAgeRange(tripId: Long, ageRange : Int){
        val call = ApplicationClass.retrofit.create(TripAgeRangeApi::class.java)
        call.deleteTripAgeRange(tripId, ageRange).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteTripAgeRange was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteTripAgeRange was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in deleteTripAgeRange: $t")
            }
        })
    }

}