package com.ssafy.gumi107.mobile_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.gumi107.mobile_app.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {

    private lateinit var binding: FragmentMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

}