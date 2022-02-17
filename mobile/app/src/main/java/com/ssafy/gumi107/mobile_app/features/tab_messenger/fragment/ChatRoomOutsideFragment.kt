package com.ssafy.gumi107.mobile_app.features.tab_messenger.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.features.tab_messenger.adapter.ChatRoomOutsideAdapter
import com.ssafy.gumi107.mobile_app.databinding.FragmentChatRoomOutsideBinding
import com.ssafy.gumi107.mobile_app.dto.ChatRoom
import kotlin.random.Random

class ChatRoomOutsideFragment :
    BaseFragment<FragmentChatRoomOutsideBinding>
        (FragmentChatRoomOutsideBinding::bind, R.layout.fragment_chat_room_outside) {
    private lateinit var chatRoomOutsideAdapter: ChatRoomOutsideAdapter
    private var sampleChatRoomOutsideList = mutableListOf<ChatRoom>()


    private fun initChatRoomOutsideList() {
        var sampleChatRoomOutside: ChatRoom
        val sampleChatRoomOutsideTitle = "가짜 타이틀"
        for (i in 1..10) {
            val randomInt: Int = Random(i).nextInt(100)
            sampleChatRoomOutside = ChatRoom(randomInt, sampleChatRoomOutsideTitle)
            sampleChatRoomOutsideList.add(sampleChatRoomOutside)
        }
    }

    private fun initRecyclerView(view: View) {
        val listener = object : ChatRoomOutsideAdapter.ChatRoomOutsideClickListener {
            override fun onClick(chatRoom: ChatRoom, position: Int) {
                val action =
                    ChatRoomOutsideFragmentDirections.actionChatRoomOutsideFragmentToChatRoomInsideFragment(
                        chatRoom)
                view.findNavController().navigate(action)
            }
        }
        chatRoomOutsideAdapter = ChatRoomOutsideAdapter(sampleChatRoomOutsideList).apply {
            setItemClickListener(listener)
        }
        binding.rcvChatRoomOutside.apply {
            adapter = chatRoomOutsideAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initChatRoomOutsideList()
        initRecyclerView(view)
    }
}