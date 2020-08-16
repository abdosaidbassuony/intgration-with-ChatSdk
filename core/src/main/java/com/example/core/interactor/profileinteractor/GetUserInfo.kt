package com.example.core.interactor.profileinteractor

import com.example.core.data.profiledata.ProfileRepository
import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

class GetUserInfo(private val profileRepository: ProfileRepository) {

    operator fun invoke(id:String?):Single<User> =
        profileRepository.getUserInfo(id)


}