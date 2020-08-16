package com.example.chatsdktest.presentation.profile

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.example.chatsdktest.R
import com.example.chatsdktest.databinding.ActivityProfileBinding
import com.example.chatsdktest.presentation.auth.AuthenticationActivity
import com.example.chatsdktest.presentation.profile.editeProfile.EditProfileFragment
import com.example.chatsdktest.presentation.profile.profileInfo.ProfileInfoFragment
import com.example.chatsdktest.utils.openActivity
import com.example.chatsdktest.utils.openFragment
import com.example.cleanarchproject.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileActivity : BaseActivity<ActivityProfileBinding>() {
    override val layoutId: Int = R.layout.activity_profile
    override val viewModel by viewModel<ProfileSharedViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()

    }

    private fun initObserver() {
        viewModel.openEditProfile.observe(this, Observer {
            openFragment(R.id.profile_container, EditProfileFragment.newInstance(), true)
        })

        viewModel.openProfileInfo.observe(this, Observer {
            openFragment(R.id.profile_container, ProfileInfoFragment.newInstance(), true)
        })

        viewModel.fragmentTitle.observe(this, Observer { title ->
            supportActionBar?.title = title
        })
        viewModel.isUserLogout.observe(this, Observer {
            openActivity(AuthenticationActivity::class.java)
        })
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
