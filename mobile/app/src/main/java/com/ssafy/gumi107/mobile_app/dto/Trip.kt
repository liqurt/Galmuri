package com.ssafy.gumi107.mobile_app.dto

import java.io.Serializable

data class Trip (
    var trip_id : Int, // PK
    var created_date : Long,
    var modified_date : Long,
    var comment : String, // 최대 255자
    var done : Boolean, // 갔던 여행이면 True, 아니면 False
    var end_date : Long,
    var max_member : Int,
    var now_member : Int,
    var start_date : Long,
    var theme : String, // 여행 테마
    var title : String
) : Serializable
