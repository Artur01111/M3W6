package com.example.m3w6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    private val _messages = MutableLiveData<MutableList<Message>>(mutableListOf())
    val messages: LiveData<MutableList<Message>> = _messages

    fun sendMessage(content: String) {
        val message = Message(content, true)
        _messages.value?.add(message)
        receiveMessage("Echo: $content")
    }

    private fun receiveMessage(content: String) {
        val message = Message(content, false)
        _messages.value?.add(message)
        _messages.value = _messages.value
    }
}