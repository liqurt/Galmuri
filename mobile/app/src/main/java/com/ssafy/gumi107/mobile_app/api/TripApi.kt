package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.Trip
import retrofit2.Call
import retrofit2.http.*

interface TripApi{

    @POST("/trip/register/")
    fun insertTrip(@Body trip : Trip) : Call<Unit>

    @GET("/trip/find/{tripId}")
    fun selectTrip(
        @Path("tripId") tripId: Long
    ) : Call<Trip>

    @PUT("/trip/update/{tripId}")
    fun updateTrip(
        @Path("tripId") tripId: Long,
        @Body trip : Trip
    ) : Call<Unit>

    @DELETE("/trip/delete/{tripId}")
    fun deleteTrip(
        @Path("tripId") tripId : Long
    ) : Call<Unit>
}