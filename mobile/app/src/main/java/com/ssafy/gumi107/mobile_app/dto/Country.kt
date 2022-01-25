package com.ssafy.gumi107.mobile_app.features.dto

data class Country(
    var countryCode : String,
    var name : String,
    var continent : String,
){
    constructor() : this("KOR","한국","아시아")
}
