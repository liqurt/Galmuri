package com.ssafy.gumi107.mobile_app.config

import android.app.Application
import android.os.Build
import com.kakao.sdk.common.KakaoSdk
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
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

        // Kakao SDK 초기화
        KakaoSdk.init(this,"0446899cd3996600e2ef713e92040857")
        val gson = GsonBuilder().setPrettyPrinting().create()

        retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }

}
