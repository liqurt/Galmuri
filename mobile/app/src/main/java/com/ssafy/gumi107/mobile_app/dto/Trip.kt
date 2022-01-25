package com.ssafy.gumi107.mobile_app.features.dto

import java.io.Serializable

data class Trip (
    var tripId : Int,
    var title : String,
    var hostId : String,
    var hostDomain : String,
    var updateDate : Long,
    var startDate : Long,
    var endDate : Long,
    var theme : String,
    var maxMember : Int,
    var nowMember : Int,
    var comment : String,
    var isDone : Boolean,
    var tripAge : MutableList<TripAge>,
    var schedule: MutableList<Schedule>,
) : Serializable{
    constructor(_updateDate: Long) : this(
        tripId = -1,
        title = "sampleTitle",
        hostId = "sampleHostId",
        hostDomain = "sampleHostDomain",
        updateDate = _updateDate,
        startDate = System.currentTimeMillis(),
        endDate = System.currentTimeMillis() + (1000*60*60*24*7),
        theme = "sampleTheme",
        maxMember = -1,
        nowMember = -1,
        comment = "sampleComment",
        isDone = false,
        tripAge = mutableListOf(
            TripAge(-1,10), TripAge(-1,30)
        ),
        schedule = mutableListOf(
            Schedule(-1, Location(Country(),"문형리",-1f,-1f),1,System.currentTimeMillis()+1000*60*60*24*1),
            Schedule(-1, Location(Country(),"추자리",-1f,-1f),3,System.currentTimeMillis()+1000*60*60*24*2),
            Schedule(-1, Location(Country(),"고산리",-1f,-1f),2,System.currentTimeMillis()+1000*60*60*24*3)
        )
    )

    override fun toString(): String {
        return "Trip(tripId=$tripId, title='$title', hostId='$hostId', hostDomain='$hostDomain', updateDate=$updateDate, startDate=$startDate, endDate=$endDate, theme='$theme', maxMember=$maxMember, nowMember=$nowMember, comment='$comment', isDone=$isDone, tripAge=$tripAge, schedule=$schedule)"
    }

}
