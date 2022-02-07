package com.ssafy.gumi107.mobile_app.dto

data class User(
    var domain : String, // PK 오직 1글자
    var userId : String, // PK
    var age : Int,
    var facebook : String,
    var gender : Boolean, // 남(1), 여(0)
    var instagram : String,
    var nickName : String,
    var twitter : String,
    var countryCode : String // FK 최대 3글자
) {
//    var created_date : Long = System.currentTimeMillis()
//    var modified_date : Long = System.currentTimeMillis()
//    var total_score : Float = 0f
//    var total_vote : Int = 0
}