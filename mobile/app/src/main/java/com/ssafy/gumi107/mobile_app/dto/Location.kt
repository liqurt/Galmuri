package com.ssafy.gumi107.mobile_app.features.dto


data class Location(
    var country : Country,
    var locationName : String,
    var latitude : Float,
    var longitude : Float
){
    constructor() : this(Country(),"문형산",-1f,-1f)
}
