package com.ssafy.gumi107.mobile_app.features.tab_messenger.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ssafy.gumi107.mobile_app.databinding.FragmentChatRoomInsideBinding
import com.ssafy.gumi107.mobile_app.dto.ChatRoom

class ChatRoomInsideFragment : Fragment() {
    private lateinit var binding : FragmentChatRoomInsideBinding
    private var chatRoom : ChatRoom? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            chatRoom = it.getSerializable("chatRoom") as ChatRoom
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentChatRoomInsideBinding.inflate(inflater, container, false)
        return binding.root
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