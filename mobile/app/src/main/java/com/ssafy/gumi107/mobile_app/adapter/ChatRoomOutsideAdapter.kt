package com.ssafy.gumi107.mobile_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.gumi107.mobile_app.databinding.RcvItemChatRoomOutsideBinding
import com.ssafy.gumi107.mobile_app.dto.ChatRoom

class ChatRoomOutsideAdapter(private val chatRoomList: MutableList<ChatRoom>) :
    RecyclerView.Adapter<ChatRoomOutsideAdapter.ChatRoomOutsideHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ChatRoomOutsideAdapter.ChatRoomOutsideHolder {
        val binding = RcvItemChatRoomOutsideBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        return ChatRoomOutsideHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatRoomOutsideHolder, position: Int) {
        holder.bindInfo(chatRoomList[position])
    }

    override fun getItemCount(): Int = chatRoomList.size


    inner class ChatRoomOutsideHolder(private val binding: RcvItemChatRoomOutsideBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindInfo(chatRoom: ChatRoom) {
            binding.chatRoomOutsideId.text = chatRoom.chatRoomId.toString()
            binding.chatRoomOutsideTitle.text = chatRoom.title
            val sampleLastMessage = "블라블라블라"
            binding.chatRoomOutsideLastChat.text = sampleLastMessage
            itemView.setOnClickListener {
                listener.onClick(chatRoom, layoutPosition)
            }
        }
    }

    interface ChatRoomOutsideClickListener {
        fun onClick(chatRoom: ChatRoom, position: Int)
    }

    lateinit var listener: ChatRoomOutsideClickListener
    fun setItemClickListener(listener: ChatRoomOutsideClickListener) {
        this.listener = listener
    }

}