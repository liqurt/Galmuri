package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.UserTrip
import retrofit2.Call
import retrofit2.http.*

interface UserTripApi {
    @DELETE ("/userTrip/delete/{userId}/{domain}/{tripId}")
    fun deleteUserTrip(
        @Path("domain") domain : String,
        @Path("tripId") tripId : Long,
        @Path("userId") userId : String,
    ) : Call<Unit>

    @GET("/userTrip/find/{tripId}")
    fun selectUserTripByTripId(
        @Path("tripId") tripId: Long
    ) : Call<List<UserTrip>>

    @GET("/userTrip/find/{userId}/{domain}")
    fun selectUserTripByUserIdAndDomain(
        @Path("domain") domain: String,
        @Path("userId") userId: String,
    ) : Call<List<UserTrip>>

    @GET("/userTrip/find/{userId}/{domain}/{tripId}")
    fun selectUserTripByUserIDAndDomainAndTripId(
        @Path("userId") tripId: Long,
        @Path("domain") domain: String,
        @Path("userId") userId: String,
    ) : Call<UserTrip>

    @POST("/userTrip/register")
    fun insertUserTrip(
        @Body userTrip: UserTrip
    ) : Call<Unit>

    @PUT("/userTrip/update/{userId}/{domain}/{tripId}")
    fun updateUserTrip(
        @Path("userId") tripId: Long,
        @Path("domain") domain: String,
        @Path("userId") userId: String,
        @Body userTrip: UserTrip
    ) : Call<Unit>
}