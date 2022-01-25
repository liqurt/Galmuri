package com.ssafy.gumi107.mobile_app.dto

data class Schedule(
    var tripId : Int,
    var location : Location,
    var order : Int,
    var time : Long
){
    constructor() : this(-1, Location(),-1,System.currentTimeMillis())
}
