package com.example.core.interactor.profileinteractor

import com.example.core.data.profiledata.ProfileRepository
import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

class UpdateUserInfo(private val profileRepository: ProfileRepository) {
    operator fun invoke(user: User): Single<User> =
        profileRepository.updateUserInfo(user)
}