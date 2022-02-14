package com.ssafy.gumi107.mobile_app.dto

data class UserTrip( // 변수이름 카멜로 해라!
    var isConfirmed : Boolean, // 여행의 참가자인가?
    var isOwn : Boolean, // 여행 주최자(호스트) 인가?
    var userId : String, // PK FK 오직 1글자
    var domain : String, // PK FK 최대 255글자
    var tripId : Long, // PK FK
)
