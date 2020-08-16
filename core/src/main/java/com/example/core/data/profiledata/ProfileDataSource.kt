package com.example.core.data.profiledata

import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

interface ProfileDataSource {

    fun updateUserInfo(user: User): Single<User>

    fun getUserInfo(id:String?): Single<User>
}