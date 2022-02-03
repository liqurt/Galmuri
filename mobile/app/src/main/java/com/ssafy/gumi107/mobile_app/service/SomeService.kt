package com.ssafy.gumi107.mobile_app.service

import com.ssafy.gumi107.mobile_app.dto.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

// 이 인터페이스는 백엔드랑 연결되는지 테스트 해보려고 만들었습니다. 언제든지 삭제가능합니다.
interface SomeService {
    @POST("user/register/")
    fun insertUser(@Body userDto: User): Call<Unit>
}