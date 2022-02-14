package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.TripAgeRange
import retrofit2.Call
import retrofit2.http.*

interface TripAgeRangeApi {

    @POST("/tripAge/register")
    fun insertTripAgeRange(
        @Body tripAgeRange: TripAgeRange
    ) : Call<Unit>

    @GET("/tripAge/find/{tripId}")
    fun selectTripAgeRangeByTripId(
        @Path("tripId") tripId: Long,
    ) : Call<List<TripAgeRange>>

    @GET("/tripAge/find/{tripId}/{ageRange}")
    fun selectTripAgeRangeByIdAndAgeRange(
        @Path("tripId") tripId: Long,
        @Path("ageRange") ageRange: Int,
    ) : Call<TripAgeRange>

    //update는 없음

    @DELETE("/tripAge/delete/{tripId}/{ageRange}")
    fun deleteTripAgeRange(
        @Path("tripId") tripId : Long,
        @Path("ageRange") ageRange : Int,
    ) : Call<Unit>
}