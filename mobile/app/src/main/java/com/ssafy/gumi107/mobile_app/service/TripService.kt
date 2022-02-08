package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.google.gson.Gson
import com.ssafy.gumi107.mobile_app.api.TripApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.Trip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TripService {

    val onFailureMessage = "연결에 문제 있음"

    fun insertUser(trip: Trip) {
        Log.d(Global.GLOBAL_LOG_TAG, Gson().toJson(trip))
        Log.d(Global.GLOBAL_LOG_TAG, "$trip")

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

    fun selectUser(tripid : Int) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.selectTrip(tripid).enqueue(object : Callback<Trip> {
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

    fun updateUser(tripid: Int ,trip: Trip) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.updateTrip(tripid, trip).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateTrip was successful")
                    Log.d(Global.GLOBAL_LOG_TAG, "onResponse: ${response.body()}")
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "updateTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in updateTrip: $t")
            }
        })
    }

    fun deleteUser(tripid : Int) {
        val call = ApplicationClass.retrofit.create(TripApi::class.java)
        call.deleteTrip(tripid).enqueue(object : Callback<Unit> {
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