package com.ssafy.gumi107.mobile_app.dto

import java.io.Serializable
import java.time.LocalDateTime

data class Trip (
    var comment : String, // 최대 255자
    var done : Boolean, // 갔던 여행이면 True, 아니면 False
    var endDate : Long,
    var maxMember : Int,
    var startDate : Long,
    var theme : String, // 여행 테마
    var title : String,
    var nowMember : Int? = 1,
    var modifiedDate : Long? = null
) : Serializable{
    var tripId : Long? = null //PK
    var createdDate : Long? = null
}
