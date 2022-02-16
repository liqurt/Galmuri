package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.ssafy.gumi107.mobile_app.api.FlagApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.dto.Flag
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlagService {
    val onFailureMessage = "문제있음"

    fun selectFlag(countryCode : String, callback:RetrofitCallback<Flag>){
        val call = ApplicationClass.retrofit.create(FlagApi::class.java)
        call.selectFlag(countryCode).enqueue(object : Callback<Flag> {
            override fun onResponse(call: Call<Flag>, response: Response<Flag>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectFlag was successful")
                    if(response.body() != null){
                        callback.onSuccess(response.code(), response.body()!!)
                    }
                }else{
                    Log.d(Global.GLOBAL_LOG_TAG, "selectFlag was not successful")
                }
            }

            override fun onFailure(call: Call<Flag>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in selectFlag: $t")
            }
        })
    }
}