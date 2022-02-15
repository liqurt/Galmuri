package com.ssafy.gumi107.mobile_app.config

import com.ssafy.gumi107.mobile_app.dto.User
import java.text.SimpleDateFormat
import java.util.*

// 앞으로 주구장창 어디서든 전역적으로 쓸 법한 걸 모아두려고 합니다.

class Global {
    companion object{

        // logcat의 태그
        const val GLOBAL_LOG_TAG = "SSAFYBREAK"

        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val sdf = SimpleDateFormat("yyyy.MM.dd", Locale.KOREA)
            return sdf.format(date)
        }

        fun getOnlyIdFromEmail(email : String) : String{
            return email.split("@")[0]
        }
    }
}