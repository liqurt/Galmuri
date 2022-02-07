package com.ssafy.gumi107.mobile_app.config

import android.app.Application
import android.util.Log
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.api.UserApi
import com.ssafy.gumi107.mobile_app.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {

    private val serverIP = "192.168.0.3" // 이건 윤승일 집 IP주소입니다. 이곳저곳에 공유하지는 마시고, "cmd - ipconfig" 으로 본인 집 IP를 찾으셔서 사용하시면 됩니다.
    private val portNum = 8080
    private val serverUrl = "http://$serverIP:$portNum/galmuri/"

    companion object {
        lateinit var retrofit: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userCRUDTestWithFakeUser()
    }

    private fun userCRUDTestWithFakeUser(){
        /**
         * 이 함수를 실행하기 전, MySQL workbench에서
         * insert into country values ("KOR", "Asia", "Korea");
         * 를 실행해주세요. User의 country_code가 FK라서 값이 없으면 들어가질 않습니다.
         * */
        val someNumber1 = 1
        val someNumber2 = 2

        val fakeUser1 = User(
            age = someNumber1,
            countryCode = "KOR",
            domain = "A",
            facebook = "AAAAA",
            gender = true,
            instagram = "AAAAA",
            nickName = "AAAAA",
            twitter = "AAAAA",
            userId = "uid${someNumber1}"
        )

        val fakeUser2 = User(
            age = someNumber2,
            countryCode = "KOR",
            domain = "B",
            facebook = "BBBBB",
            gender = true,
            instagram = "BBBBB",
            nickName = "BBBBB",
            twitter = "BBBBB",
            userId = "uid${someNumber2}"
        )

        val us = UserService()

        // insert
        us.insertUser(fakeUser1)
        us.insertUser(fakeUser2)

        // update
        fakeUser2.instagram = "CCCCC"
        us.updateUser(fakeUser2)

        // select
        us.selectUser(fakeUser2)

        // delete
        us.deleteUser(fakeUser1)

        // user에 fakeUser2만 있고, fakeUser2의 instagram이 "CCCCC" 면 정상입니다.
    }
}