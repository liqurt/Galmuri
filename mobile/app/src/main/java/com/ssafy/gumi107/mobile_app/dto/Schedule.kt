package com.ssafy.gumi107.mobile_app.dto

data class Schedule(
    var schedule_id : Int, // PK
    var latitude : Float,
    var location : String,
    var longitude : Float,
    var time : Long,
    var trip_order : Int,
    var country_code : String, // FK
    var trip_id : Int // FK
)
