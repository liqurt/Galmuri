package com.ssafy.gumi107.mobile_app.features.introduction.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.databinding.RcvItemIntroductionPageBinding
import com.ssafy.gumi107.mobile_app.dto.IntroductionPage

class IntroductionAdapter(private val introductionPageList: ArrayList<IntroductionPage>) :
    RecyclerView.Adapter<IntroductionAdapter.PagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding =
            RcvItemIntroductionPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bindInfo(introductionPageList[position])
    }

    override fun getItemCount(): Int = introductionPageList.size

    inner class PagerViewHolder(private val binding: RcvItemIntroductionPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindInfo(eachPage: IntroductionPage) {
            binding.ivIntroduction.setImageResource(eachPage.imageId)
            binding.tvIntroduction.text = eachPage.summary
        }
    }

}