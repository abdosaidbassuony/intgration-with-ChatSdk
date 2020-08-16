package com.example.chatsdktest.presentation.profile

import com.example.chatsdktest.utils.SingleLiveEvent
import com.example.cleanarchproject.ui.base.BaseViewModel

class ProfileSharedViewModel : BaseViewModel() {
    val openProfileInfo = SingleLiveEvent<Boolean>()
    val openEditProfile = SingleLiveEvent<Boolean>()
    val fragmentTitle = SingleLiveEvent<String>()
    val isUserLogout = SingleLiveEvent<Boolean>()

    init {
        openProfileInfo()
    }

    private fun openProfileInfo() {
        openProfileInfo.value = true
    }

    fun openEditProfile() {
        openEditProfile.value = true
    }

    fun setTitle(title: String) {
        fragmentTitle.value = title
    }

    fun logout() {
        isUserLogout.value = true
    }
}