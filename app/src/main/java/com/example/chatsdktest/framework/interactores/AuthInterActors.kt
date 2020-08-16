package com.example.chatsdktest.framework.interactores

import com.example.core.interactor.authinteractor.LogOut
import com.example.core.interactor.authinteractor.Login
import com.example.core.interactor.authinteractor.Register

data class AuthInterActors(
    val login: Login,
    val register: Register,
    val logOut: LogOut
)