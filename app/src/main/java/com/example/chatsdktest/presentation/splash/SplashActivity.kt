package com.example.chatsdktest.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.chatsdktest.presentation.auth.AuthenticationActivity
import com.example.chatsdktest.presentation.chat.ChatActivity
import org.koin.android.viewmodel.ext.android.viewModel


class SplashActivity : AppCompatActivity() {
    private val viewModel by viewModel<SplashViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.isUserLogin.observe(this, Observer {
            if (it) {
                startActivity(Intent(this@SplashActivity, ChatActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, AuthenticationActivity::class.java))

            }
            finish()
        })

    }
}
