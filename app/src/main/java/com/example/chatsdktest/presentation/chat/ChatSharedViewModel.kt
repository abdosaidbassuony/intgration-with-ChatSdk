package com.example.chatsdktest.presentation.chat

import com.example.chatsdktest.framework.interactores.AuthInterActors
import com.example.chatsdktest.utils.SingleLiveEvent
import com.example.cleanarchproject.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatSharedViewModel(private val authInterActors: AuthInterActors) : BaseViewModel() {
    val requestSuccess = SingleLiveEvent<Boolean>()

    fun logout() {
        authInterActors.logOut.invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                requestSuccess.value = true
            }, {})
    }
}