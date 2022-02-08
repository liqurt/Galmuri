package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @POST("/user/register/")
    fun insertUser(@Body user: User): Call<Unit>

    @GET("/user/find/{userId}/{domain}")
    fun selectUser( // select 방식이 백엔드에서 추가(where 절)되면, function이름 바꿀 거임.
        @Path("userId") userId : String,
        @Path("domain") domain : String,
    ) : Call<User>

    @PUT("/user/update/{userId}/{domain}") //path가 domain, body가 user
    fun updateUser(
        @Path("userId") userId : String,
        @Path("domain") domain : String,
        @Body user: User
    ): Call<Unit>

    @DELETE("/user/delete/{userId}/{domain}")
    fun deleteUser( // delete 방식이 백엔드에서 추가(where 절)되면, function이름 바꿀 거임.
        @Path("userId") userId : String,
        @Path("domain") domain : String,
    ) : Call<Unit>
}