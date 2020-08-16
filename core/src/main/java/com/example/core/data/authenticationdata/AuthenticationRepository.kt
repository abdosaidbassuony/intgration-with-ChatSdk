package com.example.core.data.authenticationdata

import com.example.core.data.authenticationdata.AuthenticationDataSource
import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

class AuthenticationRepository(private val authenticationDataSource: AuthenticationDataSource) {
    fun login(email: String, password: String): Single<User> =
        authenticationDataSource.login(email, password)

    fun register(email: String, password: String): Single<User> =
        authenticationDataSource.register(email,password)

    fun logOut(): Single<Unit> =
        authenticationDataSource.logOut()
}