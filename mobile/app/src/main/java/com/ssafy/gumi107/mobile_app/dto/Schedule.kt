package com.ssafy.gumi107.mobile_app.dto

data class Schedule(
    var scheduleId : Int, // PK
    var latitude : Float,
    var location : String,
    var longitude : Float,
    var time : Long,
    var tripOrder : Int,
    var countryCode : String, // FK
    var tripId : Int // FK
)
