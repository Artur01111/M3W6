package com.example.m3w6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.m3w6.databinding.FragmentChooserBinding

class ChooserFragment : Fragment() {

    private lateinit var binding: FragmentChooserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooserBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            sts.setOnClickListener{
                findNavController().navigate(R.id.action_chooserFragment_to_costumisationFragment)
            }
            calls.setOnClickListener{
                findNavController().navigate(R.id.action_chooserFragment_to_callsFragment)
            }
            contacts.setOnClickListener{
                findNavController().navigate(R.id.action_chooserFragment_to_contactsFragment2)
            }
        }
    }
}