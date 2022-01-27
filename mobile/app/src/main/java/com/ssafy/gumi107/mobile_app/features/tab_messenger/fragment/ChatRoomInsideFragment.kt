package com.ssafy.gumi107.mobile_app.features.tab_messenger.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.gumi107.mobile_app.R
import com.ssafy.gumi107.mobile_app.config.BaseFragment
import com.ssafy.gumi107.mobile_app.databinding.FragmentChatRoomInsideBinding
import com.ssafy.gumi107.mobile_app.dto.ChatRoom

class ChatRoomInsideFragment : BaseFragment<FragmentChatRoomInsideBinding>(
    FragmentChatRoomInsideBinding::bind, R.layout.fragment_chat_room_inside
) {
    private var chatRoom : ChatRoom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chatRoom = it.getSerializable("chatRoom") as ChatRoom
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(chatRoom)
    }

    private fun initView(chatRoom: ChatRoom?) {
        if(chatRoom != null){
            binding.tvChatRoomId.text = chatRoom.chatRoomId.toString()
            binding.tvChatRoomTitle.text = chatRoom.title
        }
    }

}