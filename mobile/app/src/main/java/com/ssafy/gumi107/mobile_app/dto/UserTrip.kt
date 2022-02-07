package com.ssafy.gumi107.mobile_app.dto

data class UserTrip(
    var is_confirmed : Boolean, // 여행의 참가자인가?
    var is_own : Boolean, // 여행 주최자(호스트) 인가?
    var user_id : String, // PK FK 오직 1글자
    var domain : String, // PK FK 최대 255글자
    var trip_id : Int, // PK FK
)
