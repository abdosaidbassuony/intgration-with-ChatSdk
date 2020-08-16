package com.example.chatsdktest.framework.di

import com.example.chatsdktest.framework.firebase.FirebaseAuthDataSource
import com.example.chatsdktest.framework.firebase.FirebaseProfileDataSource
import com.example.core.data.authenticationdata.AuthenticationDataSource
import com.example.core.data.authenticationdata.AuthenticationRepository
import com.example.core.data.profiledata.ProfileDataSource
import com.example.core.data.profiledata.ProfileRepository
import org.koin.dsl.bind
import org.koin.dsl.module

val dataSourceModule = module {

    single {
        FirebaseAuthDataSource()
    } bind (AuthenticationDataSource::class)

    single {
        AuthenticationRepository(get())
    }

    single {
        FirebaseProfileDataSource()
    } bind (ProfileDataSource::class)

    single {
        ProfileRepository(get())
    }

}
