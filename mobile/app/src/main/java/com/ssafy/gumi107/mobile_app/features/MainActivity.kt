package com.ssafy.gumi107.mobile_app.features

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.databinding.ActivityMainBinding
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.ssafy.gumi107.mobile_app.features.tab_home.HomeFragment


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNavigationView()


        val keyHash = Utility.getKeyHash(this)
        Log.e("해시키", keyHash)

        // 로그인 정보 확인
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            }
            else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()


                // 사용자 정보 요청 (추가 동의)

// 사용자가 로그인 시 제3자 정보제공에 동의하지 않은 개인정보 항목 중 어떤 정보가 반드시 필요한 시나리오에 진입한다면
// 다음과 같이 추가 동의를 받고 해당 정보를 획득할 수 있습니다.

//  * 주의: 선택 동의항목은 사용자가 거부하더라도 서비스 이용에 지장이 없어야 합니다.

// 사용 가능한 모든 동의 항목을 대상으로 추가 동의 필요 여부 확인 및 추가 동의를 요청하는 예제입니다.
                UserApiClient.instance.me { user, error ->
                    if (error != null) {
                        Log.e("실패", "사용자 정보 요청 실패", error)
                    }
                    else if (user != null) {
                        var scopes = mutableListOf<String>()

                        if (user.kakaoAccount?.emailNeedsAgreement == true) { scopes.add("account_email") }
                        if (user.kakaoAccount?.birthdayNeedsAgreement == true) { scopes.add("birthday") }
                        if (user.kakaoAccount?.birthyearNeedsAgreement == true) { scopes.add("birthyear") }
                        if (user.kakaoAccount?.genderNeedsAgreement == true) { scopes.add("gender") }
                        if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) { scopes.add("phone_number") }
                        if (user.kakaoAccount?.profileNeedsAgreement == true) { scopes.add("profile") }
                        if (user.kakaoAccount?.ageRangeNeedsAgreement == true) { scopes.add("age_range") }
                        if (user.kakaoAccount?.ciNeedsAgreement == true) { scopes.add("account_ci") }

                        if (scopes.count() > 0) {
                            Log.d("추가동의", "사용자에게 추가 동의를 받아야 합니다.")

                            UserApiClient.instance.loginWithNewScopes(this, scopes) { token, error ->
                                if (error != null) {
                                    Log.e("호오", "사용자 추가 동의 실패", error)
                                } else {
                                    Log.d("스코프", "allowed scopes: ${token!!.scopes}")

                                    // 사용자 정보 재요청
                                    UserApiClient.instance.me { user, error ->
                                        if (error != null) {
                                            Log.e("요청실패", "사용자 정보 요청 실패", error)
                                        }
                                        else if (user != null) {
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
    }

    private fun setBottomNavigationView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.host_nav_main) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bnvMain.setupWithNavController(navController)
    }

}