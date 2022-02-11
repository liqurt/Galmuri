package com.ssafy.gumi107.mobile_app.config

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.dto.Trip
import com.ssafy.gumi107.mobile_app.service.TripService
import com.ssafy.gumi107.mobile_app.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {

    private val serverIP =
        "3.39.31.86" // AWS
    private val portNum = 8080
    private val serverUrl = "http://$serverIP:$portNum/galmuri/"

    companion object {
        lateinit var retrofit: Retrofit
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        val gson = GsonBuilder().setPrettyPrinting().create()

        retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

}
