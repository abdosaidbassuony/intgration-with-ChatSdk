package com.example.chatsdktest

import android.app.Application
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.PhoneAuthProvider
import sdk.chat.core.session.ChatSDK
import sdk.chat.firebase.adapter.module.FirebaseModule
import sdk.chat.firebase.push.FirebasePushModule
import sdk.chat.firebase.ui.FirebaseUIModule
import sdk.chat.firebase.upload.FirebaseUploadModule
import sdk.chat.ui.module.UIModule
import java.util.concurrent.TimeUnit


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        try {
            ChatSDK.builder()
                .setGoogleMaps("Your Google Static Maps API key")
                .setPublicChatRoomLifetimeMinutes(TimeUnit.HOURS.toMinutes(24))
                .build()
                .addModule(
                    FirebaseModule.builder()
                        .setFirebaseRootPath("pre_1")
                        .setDevelopmentModeEnabled(true)
                        .build()
                )
                .addModule(
                    UIModule.builder()
                        .setPublicRoomCreationEnabled(true)
                        .setPublicRoomsEnabled(true)
                        .setGroupsEnabled(true)
                        .build()
                )
                .addModule(FirebaseUploadModule.shared())
                .addModule(FirebasePushModule.shared())
                .addModule(
                    FirebaseUIModule.builder()
                        .setProviders(EmailAuthProvider.PROVIDER_ID, PhoneAuthProvider.PROVIDER_ID)
                        .build()
                )
                .build()
                .activate(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}