package com.ssafy.gumi107.mobile_app.service

import android.util.Log
import com.google.gson.Gson
import com.ssafy.gumi107.mobile_app.api.UserApi
import com.ssafy.gumi107.mobile_app.config.ApplicationClass
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.dto.User
import retrofit2.*

// User에 관한 CRUD
class UserService {
    val onFailureMessage = "통신에 문제있음"

    /**
     * insert(Create)  - 백엔드에서 insert 방식이 더 생기면, 그에 맞게 함수이름을 추가 및 변경 하겠습니다.
     * */
    fun insertUser(user: User) {
        val call = ApplicationClass.retrofit.create(UserApi::class.java)
        call.insertUser(user).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertUser was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "insertUser was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in insertUser: $t")
            }
        })
    }

    /**
     * select(read) - 백엔드에서 select 방식이 더 생기면, 그에 맞게 함수이름을 추가 및 변경 하겠습니다.
     */
    fun selectUser(userId: String, domain:String, callback: RetrofitCallback<User>) {
        val call = ApplicationClass.retrofit.create(UserApi::class.java)
        call.selectUser(userId, domain).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectUser was successful")
                    Log.d(Global.GLOBAL_LOG_TAG, "onResponse: ${response.body()}")
                    if(response.body() != null){
                        callback.onSuccess(response.code(), response.body()!!)
                        // ?
                    }
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "selectUser was not successful")
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "selectUser was not successful")
            }
        })
    }

    /**
     * update(update)  - 백엔드에서 update 방식이 더 생기면, 그에 맞게 함수이름을 추가 및 변경 하겠습니다.
     */
    fun updateUser(user: User) {
        val call = ApplicationClass.retrofit.create(UserApi::class.java)
        call.updateUser(user.userId, user.domain, user).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateUser was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "updateUser was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "${onFailureMessage} in updateUser: $t")
            }
        })
    }

    /**
     * delete(delete)  - 백엔드에서 delete 방식이 더 생기면, 그에 맞게 함수이름을 추가 및 변경 하겠습니다.
     */
    fun deleteUser(user: User) {
        val call = ApplicationClass.retrofit.create(UserApi::class.java)
        call.deleteUser(user.userId, user.domain).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteUser was successful")
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "deleteUser was not successful")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "$onFailureMessage in deleteUser: $t")
            }
        })
    }

    fun isExistUser(userId: String, domain: String, callback: RetrofitCallback<Boolean>){
        val call = ApplicationClass.retrofit.create(UserApi::class.java)
        call.isExistUser(userId, domain).enqueue(object : Callback<Boolean>{
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                if (response.isSuccessful) {
                    if(response.body() != null){
                        callback.onSuccess(response.code(), response.body()!!)
                    }
                } else {
                    Log.d(Global.GLOBAL_LOG_TAG, "isExistUser was not successful")
                }
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                Log.d(Global.GLOBAL_LOG_TAG, "isExistUser was not successful")
            }

        })
    }
}