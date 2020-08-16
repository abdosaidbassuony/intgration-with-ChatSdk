package com.example.chatsdktest.presentation.chat

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.chatsdktest.R
import com.example.chatsdktest.databinding.ActivityChatBinding
import com.example.chatsdktest.presentation.auth.AuthenticationActivity
import com.example.chatsdktest.presentation.profile.ProfileActivity
import com.example.chatsdktest.utils.openActivity
import com.example.cleanarchproject.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ChatActivity : BaseActivity<ActivityChatBinding>() {

    override val layoutId: Int = R.layout.activity_chat
    override val viewModel by viewModel<ChatSharedViewModel>()
    private val fragmentAdapter by lazy {
        ChatFragmentAdapter(supportFragmentManager, 3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pager = binding.pager
        val tab = binding.tabLayout
        pager.adapter = fragmentAdapter
        tab.setupWithViewPager(pager)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_person_outline)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initObserver()
    }

    private fun initObserver() {
        viewModel.requestSuccess.observe(this, Observer {
            Log.e("test", it.toString())
            openActivity(AuthenticationActivity::class.java)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.manu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                viewModel.logout()
                true
            }
            android.R.id.home -> {
                openActivity(ProfileActivity::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}
