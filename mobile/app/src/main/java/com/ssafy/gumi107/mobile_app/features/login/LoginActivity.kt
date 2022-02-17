package com.ssafy.gumi107.mobile_app.features.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.util.Log

import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.databinding.ActivityLoginBinding
import com.ssafy.gumi107.mobile_app.features.MainActivity


class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initKakaoLoginButton()

    }

    private fun initKakaoLoginButton() {
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                when {
                    else -> { // Unknown
                        Log.d(Global.GLOBAL_LOG_TAG, "$error")
                    }
                }
            } else if (token != null) {
                Log.d("Global.GLOBAL_LOG_TAG", "카카오계정으로 로그인 성공 ${token.accessToken}")
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        binding.btnKakao.setOnClickListener {
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.d(Global.GLOBAL_LOG_TAG, "카카오톡으로 로그인 실패", error)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                    } else if (token != null) {
                        Log.d(Global.GLOBAL_LOG_TAG, "카카오톡으로 로그인 성공 ${token.accessToken}")
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
            }
        }
    }
}