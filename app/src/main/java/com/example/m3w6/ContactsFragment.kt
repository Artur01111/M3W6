package com.example.m3w6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.m3w6.databinding.FragmentContactsBinding

class ContactsFragment : Fragment() {

    private lateinit var binding: FragmentContactsBinding
    lateinit var adapter: ContactAdapter
    private var contacts = ArrayList<PhoneNumbers>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = ContactAdapter(contacts) {
            findNavController().navigate(R.id.action_contactsFragment2_to_chatFragment)
        }
        binding.rvContacts.adapter = adapter
    }

    private fun loadData() {
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
        contacts.add(PhoneNumbers("Artur","+996 778 163 599", "https://cs14.pikabu.ru/post_img/2023/10/28/2/1698456437192888944.jpg"))
    }
}