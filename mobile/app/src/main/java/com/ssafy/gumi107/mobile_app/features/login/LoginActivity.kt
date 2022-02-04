package com.ssafy.gumi107.mobile_app.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.databinding.ActivityLoginBinding
import com.ssafy.gumi107.mobile_app.features.MainActivity

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGoMainActivity()
    }

    /**
     * 로그인이 완료되면?
     * 1. 로그인해서 얻은 정보(성별,나이,닉네임 기타 등등)를 로컬에 저장.
     * 2. MainActivity로 이동.
     */
    private fun initGoMainActivity(){
        binding.loginDone.setOnClickListener {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}