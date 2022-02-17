package com.ssafy.gumi107.mobile_app.dto

data class Country(
    var countryCode : String, // PK, 최대 3글자  ex) "KOR"
    var continent : String, //
    var countryName : String,
)
