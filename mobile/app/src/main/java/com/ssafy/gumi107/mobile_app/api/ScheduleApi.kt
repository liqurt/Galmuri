package com.ssafy.gumi107.mobile_app.api

import com.ssafy.gumi107.mobile_app.dto.Schedule
import retrofit2.Call
import retrofit2.http.*

interface ScheduleApi {
    @DELETE("/schedule/delete/{tripId}/{tripOrder}/")
    fun deleteScheduleByIdAndOrder(
        @Path("tripId") tripId : Long
    ) : Call<Unit>

    @GET("/schedule/find/{tripId}")
    fun selectScheduleAllByTripId(
        @Path("tripId") tripId: Long
    ) : Call<List<Schedule>>

    @GET("/schedule/find/{tripId}/{tripOrder}")
    fun selectScheduleByIdAndOrder(
        @Path("tripId") tripId: Long,
        @Path("tripOrder") tripOrder :Int,
    ) : Call<Schedule>

    @POST("/schedule/register/")
    fun insertSchedule(
        @Body schedule : Schedule
    ) : Call<Unit>

    @PUT("/schedule/update/{tripId}/{tripOrder}")
    fun updateSchedule(
        @Path("tripId") tripId: Long,
        @Path("tripOrder") tripOrder: Int,
        @Body schedule: Schedule
    ) : Call<Unit>
}