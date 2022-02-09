package com.ssafy.gumi107.mobile_app.config

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.service.SomeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    private val serverIP = "192.168.0.3" // 본인 집에서 cmd켜고 ipconfig 입력 해서 확인 할 것. 이건 윤승일 집 IP 입니다...
    private val serverUrl = "http://$serverIP:9999/galmuri/"

    companion object {
        lateinit var retrofit : Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        // Kakao SDK 초기화
        KakaoSdk.init(this,"0446899cd3996600e2ef713e92040857")

        retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        testInsert()
    }

    // testInsert()는 백엔드와 연결이 되었는지 확인차 작성했습니다. 언제든 삭제할수 있습니다.
    private fun testInsert(){
        Log.d("TAG", "testInsert: ")
        val someUser = User(
            userId = "SampleId",
            domain = "G",
            age = 20,
            gender = false,
            nickname = "SampleNickName",
            totalScore = 150.5F,
            totalVote = 20
        )

        val service = retrofit.create(SomeService::class.java)
        service.insertUser(someUser).enqueue(object: Callback<Unit>{
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                Log.d("TAG", "onResponse: $response")
                if(response.isSuccessful){
                    Log.d("TAG", "response is successful: ")
                }
            }
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("TAG", "onFailure: $t")
            }
        })

    }
}