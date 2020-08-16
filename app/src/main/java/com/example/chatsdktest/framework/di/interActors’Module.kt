package com.example.chatsdktest.framework.di

import com.example.chatsdktest.framework.interactores.AuthInterActors
import com.example.chatsdktest.framework.interactores.ProfileInterActor
import com.example.core.interactor.authinteractor.LogOut
import com.example.core.interactor.authinteractor.Login
import com.example.core.interactor.authinteractor.Register
import com.example.core.interactor.profileinteractor.GetUserInfo
import com.example.core.interactor.profileinteractor.UpdateUserInfo
import org.koin.dsl.module

val interActorsModule = module {
    single {
        AuthInterActors(
            get(),
            get(),
            get()
        )
    }
    single {
        ProfileInterActor(get(), get())
    }
    single {
        Login(get())
    }
    single {
        Register(get())
    }
    single {
        LogOut(get())
    }
    single {
        UpdateUserInfo(get())
    }
    single {
        GetUserInfo(get())
    }
}