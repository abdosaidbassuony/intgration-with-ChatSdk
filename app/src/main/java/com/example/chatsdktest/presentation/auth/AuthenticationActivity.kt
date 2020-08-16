package com.example.chatsdktest.presentation.auth

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.chatsdktest.R
import com.example.chatsdktest.databinding.ActivityAuthentecationBinding
import com.example.chatsdktest.presentation.chat.ChatActivity
import com.example.chatsdktest.utils.openActivity
import com.example.cleanarchproject.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class AuthenticationActivity : BaseActivity<ActivityAuthentecationBinding>() {

    override val viewModel: AuthenticationViewModel by viewModel()

    override val layoutId: Int = R.layout.activity_authentecation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListener()

        initObserver()
    }

    private fun initObserver() {
        viewModel.requestSuccess.observe(this, Observer {
            Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
            Log.e("test", it)
            openActivity(ChatActivity::class.java)
        })
        viewModel.requestError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            Log.e("test", it)
        })
    }

    private fun initListener() {
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.login(email, password)
        }
        binding.registerBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            viewModel.register(email, password)
        }
    }

}
