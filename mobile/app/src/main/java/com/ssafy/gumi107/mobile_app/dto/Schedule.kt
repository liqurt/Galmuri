package com.ssafy.gumi107.mobile_app.dto

data class Schedule(
    var latitude : Float,
    var location : String,
    var longitude : Float,
    var time : Long,
    var tripOrder : Int, // PK
    var countryCode : String, // FK
    var tripId : Long // FK PK
)
