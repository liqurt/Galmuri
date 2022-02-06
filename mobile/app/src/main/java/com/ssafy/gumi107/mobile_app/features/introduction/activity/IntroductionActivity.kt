package com.ssafy.gumi107.mobile_app.features.introduction.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.databinding.ActivityIntroductionBinding
import com.ssafy.gumi107.mobile_app.dto.IntroductionPage
import com.ssafy.gumi107.mobile_app.features.introduction.adapter.IntroductionAdapter
import com.ssafy.gumi107.mobile_app.features.login.LoginActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


class IntroductionActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntroductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager2()
        initLoginButton()
    }

    private fun initLoginButton() {
        binding.btSkip.setOnClickListener {
            val intent = Intent(this@IntroductionActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initViewPager2() {
        val fakeIntroductionPageList : ArrayList<IntroductionPage> =
            arrayListOf(
                IntroductionPage(R.drawable.empty,"비었음"),
                IntroductionPage(R.drawable.fakemap,"산과 들이 우거진 문형리"),
                IntroductionPage(R.drawable.fake_chat,"블라블라 어쩌고 저쩌고"),
            )

        binding.vp2Introduction.apply {
            adapter = IntroductionAdapter(ArrayList(fakeIntroductionPageList))
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        //Indicator 달기
        binding.dotsIndicator.setViewPager2(binding.vp2Introduction)

    }
}