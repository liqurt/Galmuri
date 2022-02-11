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
        "192.168.0.3" // 이건 윤승일 집 IP주소입니다. 이곳저곳에 공유하지는 마시고, "cmd - ipconfig" 으로 본인 집 IP를 찾으셔서 사용하시면 됩니다.
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

        insertFakeUser()

    }

    private fun insertFakeUser() {
        val us = UserService()
        val someNumber = 20
        val fakeUser = User(
            age = someNumber,
            countryCode = "KOR",
            domain = "A",
            facebook = "Facebook$someNumber",
            gender = true,
            instagram = "Insta$someNumber",
            nickName = "홍길동",
            twitter = "Twit$someNumber",
            userId = "uid${someNumber}"
        )
        Global.me = fakeUser
        us.insertUser(fakeUser)
    }

}
