package com.example.m3w6

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m3w6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val chatViewModel: ChatViewModel by viewModels()

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
                chatViewModel.sendMessage(messageContent)
                binding.editTextMessage.text.clear()
            }
        }
    }
}