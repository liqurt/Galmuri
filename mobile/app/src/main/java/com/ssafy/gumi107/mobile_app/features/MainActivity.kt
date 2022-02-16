package com.ssafy.gumi107.mobile_app.features

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.databinding.ActivityMainBinding
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AgeRange
import com.ssafy.gumi107.mobile_app.config.Global
import com.ssafy.gumi107.mobile_app.config.Global.Companion.me
import com.ssafy.gumi107.mobile_app.config.RetrofitCallback
import com.ssafy.gumi107.mobile_app.dto.User
import com.ssafy.gumi107.mobile_app.service.UserService


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigationView()

        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                UserApiClient.instance.me { user, error ->
                    if (error != null) {
                        Log.e("실패", "사용자 정보 요청 실패", error)
                    } else if (user != null) {
                        var scopes = mutableListOf<String>()

                        if (user.kakaoAccount?.emailNeedsAgreement == true) {
                            scopes.add("account_email")
                        }
                        if (user.kakaoAccount?.birthdayNeedsAgreement == true) {
                            scopes.add("birthday")
                        }
                        if (user.kakaoAccount?.birthyearNeedsAgreement == true) {
                            scopes.add("birthyear")
                        }
                        if (user.kakaoAccount?.genderNeedsAgreement == true) {
                            scopes.add("gender")
                        }
                        if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) {
                            scopes.add("phone_number")
                        }
                        if (user.kakaoAccount?.profileNeedsAgreement == true) {
                            scopes.add("profile")
                        }
                        if (user.kakaoAccount?.ageRangeNeedsAgreement == true) {
                            scopes.add("age_range")
                        }
                        if (user.kakaoAccount?.ciNeedsAgreement == true) {
                            scopes.add("account_ci")
                        }

                        if (scopes.count() > 0) {
                            Log.d("추가동의", "사용자에게 추가 동의를 받아야 합니다.")

                            UserApiClient.instance.loginWithNewScopes(this,
                                scopes) { token, error ->
                                if (error != null) {
                                    Log.e("호오", "사용자 추가 동의 실패", error)
                                } else {
                                    Log.d("스코프", "allowed scopes: ${token!!.scopes}")

                                    // 사용자 정보 재요청
                                    UserApiClient.instance.me { user, error ->
                                        if (error != null) {
                                            Log.e("요청실패", "사용자 정보 요청 실패", error)
                                        } else if (user != null) {
                                            Log.i("요청성공", "사용자 정보 요청 성공")
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        userRegister()
    }

    private fun setBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_nav_main) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bnvMain.setupWithNavController(navController)
    }

    private fun userRegister() {
        val domain = "K"
        UserApiClient.instance.me { user, error ->
            user?.kakaoAccount?.email?.let {
                val userId = Global.getOnlyIdFromEmail(it)

                val us = UserService()
                us.isExistUser(userId, domain, IsExistCallback())
            }
        }
    }

    inner class IsExistCallback : RetrofitCallback<Boolean> {
        override fun onError(t: Throwable) {
            Log.d(Global.GLOBAL_LOG_TAG, "onError: ")
        }

        override fun onSuccess(code: Int, responseData: Boolean) {
            Log.d(Global.GLOBAL_LOG_TAG, "회원 가입이 되어있나?: $responseData")
            if (!responseData) {
                UserApiClient.instance.me { user, error ->
                    user?.kakaoAccount?.email?.let {
                        me.userId = Global.getOnlyIdFromEmail(it)
                    }
                    me.nickName = user?.kakaoAccount?.profile?.nickname.toString()
                    me.gender = user?.kakaoAccount?.gender.toString() == "MALE"
                    me.domain = "K"
                    me.age = getAgeFromAgeRange(user?.kakaoAccount?.ageRange)
                    me.photoUrl = user?.kakaoAccount?.profile?.profileImageUrl

                    val us = UserService()
                    us.insertUser(me)
                }

            }
        }

        override fun onFailure(code: Int) {
            Log.d(Global.GLOBAL_LOG_TAG, "onFailure: ")
        }

        private fun getAgeFromAgeRange(ageRange: AgeRange?): Int {
            when (ageRange.toString()) {
                "AGE_0_9" -> return 5
                "AGE_10_14" -> return 12
                "AGE_15_19" -> return 17
                "AGE_20_29" -> return 25
                "AGE_30_39" -> return 35
                "AGE_40_49" -> return 45
                "AGE_50_59" -> return 55
                "AGE_60_69" -> return 65
                "AGE_70_79" -> return 75
                "AGE_80_89" -> return 85
                "AGE_90_ABOVE" -> return 90
            }
            return 0
        }
    }

}