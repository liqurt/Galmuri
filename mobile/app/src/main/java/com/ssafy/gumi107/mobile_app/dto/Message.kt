package com.ssafy.gumi107.mobile_app.dto

data class Message(
    var messageId : Int,
    var chatRoom: ChatRoom,
    var user : User,
    var time : Long,
    var content : String,
){
}
