package com.example.core.data.profiledata

import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

class ProfileRepository(private val profileDataSource: ProfileDataSource) {

    fun updateUserInfo(user: User): Single<User> =
        profileDataSource.updateUserInfo(user)

    fun getUserInfo(id:String?): Single<User> =
        profileDataSource.getUserInfo(id)
}