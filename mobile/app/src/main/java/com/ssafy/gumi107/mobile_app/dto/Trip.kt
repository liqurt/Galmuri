package com.ssafy.gumi107.mobile_app.dto

import java.io.Serializable
import java.time.LocalDateTime

data class Trip (
    var comment : String, // 최대 255자
    var done : Boolean, // 갔던 여행이면 True, 아니면 False
    var end_date : LocalDateTime,
    var max_member : Int,
    var start_date : LocalDateTime,
    var theme : String, // 여행 테마
    var title : String
) : Serializable{
    var trip_id : Int? = null //PK
    var created_date : LocalDateTime? = null
    var modified_date : LocalDateTime? = null
    var now_member : Int? = null
}
