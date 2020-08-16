package com.example.core.data.authenticationdata

import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

interface AuthenticationDataSource {

    fun login(email: String, password: String):Single<User>

    fun register(email: String, password: String):Single<User>

    fun logOut():Single<Unit>
}