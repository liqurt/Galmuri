package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.Flag
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FlagApi {
    @GET("/flag/read/{countryCode}")
    fun selectFlag(
        @Path("countryCode") countryCode : String
    ) : Call<Flag>
}