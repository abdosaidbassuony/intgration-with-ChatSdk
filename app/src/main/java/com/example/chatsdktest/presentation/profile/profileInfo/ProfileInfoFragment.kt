package com.example.chatsdktest.presentation.profile.profileInfo

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chatsdktest.R
import com.example.chatsdktest.databinding.FragmentProfileInfoBinding
import com.example.chatsdktest.presentation.profile.ProfileSharedViewModel
import com.example.cleanarchproject.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class ProfileInfoFragment : BaseFragment<FragmentProfileInfoBinding>() {
    override val viewModel by viewModel<ProfileInfoViewModel>()
    override val layoutId: Int = R.layout.fragment_profile_info
    val sharedViewModel by sharedViewModel<ProfileSharedViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.isGetUserInfo.observe(viewLifecycleOwner, Observer {
            binding.emailText.text = it.email
            binding.userNameText.text = it.name
            Glide.with(this).load(it.urlImage).into(binding.profileImage)
        })
        viewModel.progressBar.observe(viewLifecycleOwner, Observer {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
                binding.progressBar.progress
            } else {
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun initListener() {
        binding.editFloatBtn.setOnClickListener {
            sharedViewModel.openEditProfile()
        }
    }

    companion object {
        fun newInstance() = ProfileInfoFragment()
    }
}
