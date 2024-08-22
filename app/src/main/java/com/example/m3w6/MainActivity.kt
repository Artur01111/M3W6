package com.example.m3w6

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m3w6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val chatViewModel: ChatViewModel by viewModels()
    private var isUserTurn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatAdapter = ChatAdapter(chatViewModel.messages.value ?: listOf())
        binding.recyclerViewChat.adapter = chatAdapter
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(this)

        chatViewModel.messages.observe(this) { messages ->
            chatAdapter.notifyDataSetChanged()
            binding.recyclerViewChat.scrollToPosition(messages.size - 1)
        }

        binding.buttonSend.setOnClickListener {
            val messageContent = binding.editTextMessage.text.toString()
            if (messageContent.isNotEmpty()) {
                if (isUserTurn) {
                    chatViewModel.sendMessage(messageContent, true)
                    binding.buttonSend.setBackgroundColor(Color.BLUE)
                } else {
                    chatViewModel.sendMessage("Echo: $messageContent", false)
                    binding.buttonSend.setBackgroundColor(Color.GREEN)
                }
                isUserTurn = !isUserTurn
                binding.editTextMessage.text.clear()
            }
        }
    }
}