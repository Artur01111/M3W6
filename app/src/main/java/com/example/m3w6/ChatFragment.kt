package com.example.m3w6

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.m3w6.databinding.FragmentChatBinding

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            var state = false
            buttonSend.setOnClickListener{
                if (!state){
                    buttonSend.setBackgroundColor(Color.GREEN)
                    context?.getResources()
                        ?.let { it1 -> buttonSend.setTextColor(it1.getColor(R.color.black)) }
                    val textMessage = TextView(context).apply {
                        setText(editTextMessage.text)
                        setTextColor(context.getResources().getColor(R.color.blue))
                        textSize = 16f
                    }
                    textMessage.gravity = Gravity.START
                    chatLt.addView(textMessage)
                    state = true
                    editTextMessage.text = null
                } else{
                    buttonSend.setBackgroundColor(Color.BLUE)
                    buttonSend.setTextColor(requireActivity().getApplication().getResources().getColor(R.color.white))
                    val textMessage = TextView(context).apply {
                        setText(editTextMessage.text)
                        setTextColor(context.getResources().getColor(R.color.green))
                        textSize = 16f
                    }
                    textMessage.gravity = Gravity.END
                    chatLt.addView(textMessage)
                    state = false
                    editTextMessage.text = null
                }
            }
        }
    }
}