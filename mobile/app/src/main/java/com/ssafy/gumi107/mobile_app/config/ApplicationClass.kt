package com.ssafy.gumi107.mobile_app.config

import android.app.Application
import android.util.Log
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.api.UserApi
import com.ssafy.gumi107.mobile_app.service.UserService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    override fun onCreate() {
        super.onCreate()
        retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userCRUDTestWithFakeUser()

    }

    private fun userCRUDTestWithFakeUser() {
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

        /**
         * 이상적인 방향 : 서버에 request를 보내고 successful을 응답받으면, 다음 request 보내기. (request->response 시간이 유동적임)
         * 차선책 : request를 보내고 응답을 받는 시간을 0.05초로 설정. 0.05초 안에 왠만하면 응답을 받음. 0.05초 마다 request를 날림.
         * 결론 : 서버에 fakeUser2만 있고, fakeUser2의 instagram이 "CCCCC" 면 정상입니다.
         */
        val delayForSync : Long = 50
        val us = UserService()
        us.insertUser(fakeUser1)
        Thread.sleep(delayForSync)
        us.insertUser(fakeUser2)
        Thread.sleep(delayForSync)
        fakeUser2.instagram = "CCCCC"
        us.updateUser(fakeUser2)
        Thread.sleep(delayForSync)
        us.selectUser(fakeUser2)
        Thread.sleep(delayForSync)
        us.deleteUser(fakeUser1)
    }
}
