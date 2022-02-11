package com.ssafy.gumi107.mobile_app.config

interface RetrofitCallback <T> {
    fun onError(t:Throwable)
    fun onSuccess(code:Int, responseData:T)
    fun onFailure(code:Int)
}