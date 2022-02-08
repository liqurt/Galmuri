package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.ssafy.gumi107.mobile_app.api.TripApi
import com.ssafy.gumi107.mobile_app.api.UserApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.Trip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripService {

    val onFailureMessage = "연결에 문제 있음"

    fun insertUser(trip: Trip) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.insertTrip(trip).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertTrip was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "insertTrip was not successful")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in insertTrip: $t")
            }
        })
    }

    fun selectUser(trip : Trip) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.selectTrip(trip.trip_id).enqueue(object : Callback<Trip> {
            override fun onResponse(call: Call<Trip>, response: Response<Trip>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTrip was successful")
                    Log.d(Global.GLOBAL_LOG_TAG, "onResponse: ${response.body()}")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Trip>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in selectTrip: $t")
            }
        })
    }

    fun updateUser(trip: Trip) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.updateTrip(trip.trip_id, trip).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateTrip was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "updateTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in updateTrip: $t")
            }
        })
    }

    fun deleteUser(trip: Trip) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.deleteTrip(trip.trip_id).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteTrip was successful")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in deleteTrip: $t")
            }
        })
    }

}