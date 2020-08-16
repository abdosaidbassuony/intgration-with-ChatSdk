package com.example.chatsdktest.presentation.profile.profileInfo

import com.example.chatsdktest.framework.interactores.ProfileInterActor
import com.example.chatsdktest.utils.SingleLiveEvent
import com.example.cleanarchproject.ui.base.BaseViewModel
import com.example.core.domain.User
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class ProfileInfoViewModel(private val profileInterActor: ProfileInterActor) : BaseViewModel() {
    val isGetUserInfo = SingleLiveEvent<User>()
    val requestFail = SingleLiveEvent<String>()
    val progressBar = SingleLiveEvent<Boolean>()

    init {
        getUserInfo(FirebaseAuth.getInstance().currentUser?.uid)
    }

    private fun getUserInfo(id: String?) {
        profileInterActor.getUserInfo.invoke(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                progressBar.value = true
            }
            .subscribe({
                progressBar.value = false
                isGetUserInfo.value = it
            }, {
                requestFail.value = it.message.toString()
            })
    }
}