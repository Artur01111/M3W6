package com.example.m3w6

import android.provider.ContactsContract.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m3w6.databinding.ItemContactsBinding

class ContactAdapter(val contacts: ArrayList<PhoneNumbers>, val onItemClick: () -> Unit):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    inner class ContactViewHolder(private val binding: ItemContactsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(phoneNumbers: PhoneNumbers){
            binding.apply {
                Glide.with(imgContact).load(phoneNumbers.image).into(imgContact)
                tvNumber. text = phoneNumbers.number
                tvName.text = phoneNumbers.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.onBind(contacts.get(position))
        holder.itemView.setOnClickListener{
            onItemClick.invoke()
        }
    }
}