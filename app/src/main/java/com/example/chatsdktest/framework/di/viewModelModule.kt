package com.example.chatsdktest.framework.di

import com.example.chatsdktest.presentation.auth.AuthenticationViewModel
import com.example.chatsdktest.presentation.chat.ChatSharedViewModel
import com.example.chatsdktest.presentation.profile.ProfileSharedViewModel
import com.example.chatsdktest.presentation.profile.editeProfile.EditProfileViewModel
import com.example.chatsdktest.presentation.profile.profileInfo.ProfileInfoViewModel
import com.example.chatsdktest.presentation.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        AuthenticationViewModel(get())
    }
    viewModel {
        ChatSharedViewModel(get())
    }
    viewModel {
        SplashViewModel()
    }
    viewModel {
        ProfileSharedViewModel()
    }
    viewModel {
        EditProfileViewModel(get(), get())
    }
    viewModel {
        ProfileInfoViewModel(get())
    }
}