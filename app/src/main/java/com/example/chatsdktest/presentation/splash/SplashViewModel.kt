package com.example.chatsdktest.presentation.splash

import com.example.chatsdktest.utils.SingleLiveEvent
import com.example.cleanarchproject.ui.base.BaseViewModel
import com.google.firebase.auth.FirebaseAuth

class SplashViewModel(private val auth: FirebaseAuth = FirebaseAuth.getInstance()) :
    BaseViewModel() {

    val isUserLogin = SingleLiveEvent<Boolean>()



    init {
        checkIsUserLogin()
    }

    private fun checkIsUserLogin() {
        isUserLogin.value = auth.currentUser != null
    }


}