package com.ssafy.gumi107.mobile_app.features.config

import android.widget.Toast
import com.ssafy.gumi107.mobile_app.features.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class Constants {
    companion object{
        fun convertLongToTime(time: Long): String {
            val date = Date(time)
            val sdf = SimpleDateFormat("yyyy.MM.dd")
            return sdf.format(date)
        }
    }
}