package com.example.chatsdktest.framework.interactores

import com.example.core.interactor.profileinteractor.GetUserInfo
import com.example.core.interactor.profileinteractor.UpdateUserInfo

data class ProfileInterActor(
    val updateUserInfo: UpdateUserInfo,
    val getUserInfo: GetUserInfo
)