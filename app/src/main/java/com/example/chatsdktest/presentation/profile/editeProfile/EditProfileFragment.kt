package com.example.chatsdktest.presentation.profile.editeProfile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chatsdktest.R
import com.example.chatsdktest.databinding.FragmentEditeProfileBinding
import com.example.chatsdktest.presentation.profile.ProfileSharedViewModel
import com.example.cleanarchproject.ui.base.BaseFragment
import com.example.core.domain.User
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class EditProfileFragment : BaseFragment<FragmentEditeProfileBinding>() {
    private val REQUEST_CODE: Int = 100
    override val viewModel by viewModel<EditProfileViewModel>()
    override val layoutId: Int = R.layout.fragment_edite_profile
    private val sharedViewModel by sharedViewModel<ProfileSharedViewModel>()
    private var imageUri: Uri? = null
    private var email: String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initObserver()
    }

    private fun initObserver() {
        viewModel.requestSuccess.observe(viewLifecycleOwner, Observer {
            if (it)
                sharedViewModel.logout()
        })
        viewModel.isUpdateUserInfo.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(context, "updated", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.isGetUserInfo.observe(viewLifecycleOwner, Observer {
            binding.emailEditText.setText(it.email)
            binding.userNameEditText.setText(it.name)
            Glide.with(this).load(it.urlImage).into(binding.profileImage)
        })
        viewModel.progressBar.observe(viewLifecycleOwner, Observer {
            if (it){
                binding.progressBar.visibility =View.VISIBLE
                binding.progressBar.progress
            }else{
                binding.progressBar.visibility =View.GONE
            }
        })
    }

    private fun initListener() {
        Log.e("test", FirebaseAuth.getInstance().currentUser?.email!!)
        binding.logoutFloatBtn.setOnClickListener {
            viewModel.logout()
        }
        binding.doneFloatBtn.setOnClickListener {
            email = if (binding.emailEditText.text.toString().isNotEmpty()) {
                binding.emailEditText.text.toString()
            } else {
                FirebaseAuth.getInstance().currentUser?.email
            }

            val userName = binding.userNameEditText.text.toString()
            val id = FirebaseAuth.getInstance().currentUser?.uid

            viewModel.updateUserInfo(
                User(
                    email = email,
                    uid = id,
                    name = userName,
                    urlImage = imageUri.toString()
                )
            )
        }
        binding.profileImage.setOnClickListener {
            openGalleryForImage()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = data?.data
            Glide.with(this).load(data?.data).into(binding.profileImage)
        }

    }

    companion object {
        fun newInstance() = EditProfileFragment()
    }
}
