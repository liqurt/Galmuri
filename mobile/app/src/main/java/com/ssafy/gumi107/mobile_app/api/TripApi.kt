package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.Trip
import retrofit2.Call
import retrofit2.http.*

interface TripApi{
    @DELETE("/trip/delete/{tripId}")
    fun deleteTrip(
        @Path("tripId") tripId : Int
    ) : Call<Unit>

    @GET("/trip/find/{tripId}")
    fun selectTrip(
        @Path("tripId") tripId: Int
    ) : Call<Trip>

    @POST("/trip/register")
    fun insertTrip(
        @Body trip : Trip
    ) : Call<Unit>

    @PUT("/trip/update/{tripId}")
    fun updateTrip(
        @Path("tripId") tripId: Int,
        @Body trip : Trip
    ) : Call<Unit>
}