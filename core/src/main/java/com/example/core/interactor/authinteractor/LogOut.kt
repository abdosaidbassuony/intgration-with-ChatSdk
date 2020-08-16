package com.example.core.interactor.authinteractor

import com.example.core.data.authenticationdata.AuthenticationRepository
import io.reactivex.rxjava3.core.Single

class LogOut(private val authenticationRepository: AuthenticationRepository) {
    operator fun invoke():Single<Unit> = authenticationRepository.logOut()
}