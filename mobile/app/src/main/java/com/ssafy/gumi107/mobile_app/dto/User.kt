package com.ssafy.gumi107.mobile_app.dto

data class User(
    var userId : String,
    var domain : String,
    var age : Int,
    var gender : Boolean,
    var nickname : String,
    var totalScore : Float,
    var totalVote : Int,
)