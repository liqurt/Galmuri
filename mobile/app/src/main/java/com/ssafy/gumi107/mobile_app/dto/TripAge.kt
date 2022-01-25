package com.ssafy.gumi107.mobile_app.features.dto

data class TripAge(
    var tripId : Int,
    var ageRange : Int,
){
    constructor() : this(-1, -1)
}
