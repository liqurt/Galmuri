package com.ssafy.gumi107.mobile_app.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}