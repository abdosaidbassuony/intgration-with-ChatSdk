package com.example.core.interactor.authinteractor

import com.example.core.data.authenticationdata.AuthenticationRepository
import com.example.core.domain.User
import io.reactivex.rxjava3.core.Single

class Register(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke(email: String, password: String) : Single<User> =
        authenticationRepository.register(email, password)
}