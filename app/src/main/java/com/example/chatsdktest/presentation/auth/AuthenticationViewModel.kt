package com.example.chatsdktest.presentation.auth

import com.example.chatsdktest.framework.interactores.AuthInterActors
import com.example.chatsdktest.utils.SingleLiveEvent
import com.example.cleanarchproject.ui.base.BaseViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class AuthenticationViewModel(private val authInterActors: AuthInterActors):BaseViewModel() {

    val requestSuccess = SingleLiveEvent<String>()
    val requestError = SingleLiveEvent<String>()


    fun login(email:String,password:String){
        authInterActors.login.invoke(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
             requestSuccess.value = it.toString()
            },{
               requestError.value =it.message.toString()
            })
    }

    fun register(email:String,password:String){
        authInterActors.register.invoke(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                requestSuccess.value = it.toString()
            },{
                requestError.value =it.message.toString()
            })
    }


}