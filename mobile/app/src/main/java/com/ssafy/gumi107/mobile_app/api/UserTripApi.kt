package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.Trip
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.dto.UserTrip
import retrofit2.Call
import retrofit2.http.*

interface UserTripApi {
    @POST("/userTrip/register")
    fun insertUserTrip(
        @Body userTrip: UserTrip
    ) : Call<Unit>

    @GET("/userTrip/find/{tripId}")
    fun selectUsersByTripId(
        @Path("tripId") tripId: Long
    ) : Call<List<User>>

    @GET("/userTrip/find/{userId}/{domain}")
    fun selectTripsByUserIdAndDomain(
        @Path("userId") userId: String,
        @Path("domain") domain: String,
    ) : Call<List<Trip>>

    @GET("/userTrip/find/{userId}/{domain}/{tripId}")
    fun selectUserTripByUserIDAndDomainAndTripId(
        @Path("userId") userId: String,
        @Path("domain") domain: String,
        @Path("tripId") tripId: Long,
    ) : Call<UserTrip>

    @PUT("/userTrip/update/{userId}/{domain}/{tripId}")
    fun updateUserTrip(
        @Path("userId") userId: String,
        @Path("domain") domain: String,
        @Path("tripId") tripId: Long,
        @Body userTrip: UserTrip
    ) : Call<Unit>

    @DELETE ("/userTrip/delete/{userId}/{domain}/{tripId}")
    fun deleteUserTrip(
        @Path("userId") userId: String,
        @Path("domain") domain: String,
        @Path("tripId") tripId: Long,
    ) : Call<Unit>
}