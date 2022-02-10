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

//        userCRUDTestWithFakeUser()
//        tripCRUDTestWithFakeUser()

    }

    private fun tripCRUDTestWithFakeUser() {
        val delay = 100L
        val someNumber1 = 100
        val someNumber2 = 200
        val fakeTrip1 = Trip(
            comment = "android$someNumber1",
            done = false,
            endDate = System.currentTimeMillis(),
            maxMember = someNumber1,
            startDate = System.currentTimeMillis(),
            theme = "android$someNumber1",
            title = "android$someNumber1"
        )
        val fakeTrip2 = Trip(
            comment = "android$someNumber2",
            done = false,
            endDate = System.currentTimeMillis(),
            maxMember = someNumber2,
            startDate = System.currentTimeMillis(),
            theme = "android$someNumber2",
            title = "android$someNumber2"
        )
        val ts = TripService()
        ts.insertTrip(fakeTrip1)
        Thread.sleep(delay)
        ts.insertTrip(fakeTrip2)
        Thread.sleep(delay)

        fakeTrip2.comment="변수 이름은 카멜케이스"
        val fakeTrip2Id = 3L // 지금은 Join을 통해서 TripID를 따로 받아올수 없기에 임의로 설정해 두었습니다. DB의 테이블 보시고 직접 이 값을 수정해주세요.
        ts.updateTrip(fakeTrip2Id, fakeTrip2)
        Thread.sleep(delay)

        ts.selectTrip(fakeTrip2Id)
        Thread.sleep(delay)

        val fakeTrip1Id = 4L
        ts.deleteTrip(fakeTrip1Id)
        Thread.sleep(delay)

        // fakeTrip2만 남고, comment가 변경이 되었다면 OK
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
