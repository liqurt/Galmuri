package com.ssafy.gumi107.mobile_app.dto

data class Country(
    var country_code : String, // PK, 최대 3글자  ex) "KOR"
    var continent : String, //
    var country_name : String,
)
