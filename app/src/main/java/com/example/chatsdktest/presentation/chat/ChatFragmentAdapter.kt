package com.example.chatsdktest.presentation.chat

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ChatFragmentAdapter(fragmentManager: FragmentManager, private val tab: Int) :
    FragmentStatePagerAdapter(fragmentManager, tab) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> ConversationFragment()
            1 -> ChatRoomFragment()
            2 -> ContactsFragment()

            else -> ConversationFragment()
        }
    }

    override fun getCount(): Int {
        return tab
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0->"Conversation"
            1->"ChatRoom"
            2->"Contacts"
            else ->"Conversation"
        }
    }
}