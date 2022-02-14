package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.ssafy.gumi107.mobile_app.api.TripAgeRangeApi
import com.ssafy.gumi107.mobile_app.api.UserTripApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.dto.TripAgeRange
import com.ssafy.gumi107.mobile_app.dto.UserTrip
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserTripService {

    val onFailureMessage = "연결에 문제 있음"

    fun insertUserTrip(userTrip: UserTrip) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.insertUserTrip(userTrip).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertUserTrip was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertUserTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in insertUserTrip: $t")
            }
        })
    }

    fun selectUserTripByTripId(tripId: Long) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.selectUserTripByTripId(tripId).enqueue(object : Callback<List<UserTrip>> {
            override fun onResponse(
                call: Call<List<UserTrip>>,
                response: Response<List<UserTrip>>,
            ) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectUserTripByTripId was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectUserTripByTripId was not successful")
                }
            }

            override fun onFailure(call: Call<List<UserTrip>>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectUserTripByTripId: $t")
            }
        })
    }

    fun selectUserTripByUserIdAndDomain(userId: String, domain: String) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.selectUserTripByUserIdAndDomain(userId, domain)
            .enqueue(object : Callback<List<UserTrip>> {
                override fun onResponse(
                    call: Call<List<UserTrip>>,
                    response: Response<List<UserTrip>>,
                ) {
                    if (response.isSuccessful) {
                        Log.d(Global.GLOBAL_LOG_TAG,
                            "selectUserTripByUserIdAndDomain was successful")
                    } else {
                        Log.d(Global.GLOBAL_LOG_TAG,
                            "selectUserTripByUserIdAndDomain was not successful")
                    }
                }

                override fun onFailure(call: Call<List<UserTrip>>, t: Throwable) {
                    Log.d(Global.GLOBAL_LOG_TAG,
                        "$onFailureMessage in selectUserTripByUserIdAndDomain: $t")
                }
            })
    }

    fun selectUserTripByUserIDAndDomainAndTripId(userId: String, domain: String, tripId: Long) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.selectUserTripByUserIDAndDomainAndTripId(userId, domain, tripId)
            .enqueue(object : Callback<UserTrip> {
                override fun onResponse(call: Call<UserTrip>, response: Response<UserTrip>) {
                    if (response.isSuccessful) {
                        Log.d(Global.GLOBAL_LOG_TAG,
                            "selectUserTripByUserIDAndDomainAndTripId was successful")
                    } else {
                        Log.d(Global.GLOBAL_LOG_TAG,
                            "selectUserTripByUserIDAndDomainAndTripId was not successful")
                    }
                }

                override fun onFailure(call: Call<UserTrip>, t: Throwable) {
                    Log.d(Global.GLOBAL_LOG_TAG,
                        "$onFailureMessage in selectUserTripByUserIDAndDomainAndTripId: $t")
                }
            })
    }

    fun updateUserTrip(userId: String, domain: String, tripId: Long, userTrip: UserTrip) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.updateUserTrip(userId, domain, tripId, userTrip).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateUserTrip was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateUserTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in updateUserTrip: $t")
            }
        })
    }

    fun deleteUserTrip(userId: String, domain: String, tripId: Long) {
        val call = ApplicationClass.retrofit.create(UserTripApi::class.java)
        call.deleteUserTrip(userId, domain, tripId).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteUserTrip was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteUserTrip was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in deleteUserTrip: $t")
            }
        })
    }
}