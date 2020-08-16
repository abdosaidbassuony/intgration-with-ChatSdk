package com.example.chatsdktest.framework.firebase

import com.example.core.data.authenticationdata.AuthenticationDataSource
import com.example.core.domain.User
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.rxjava3.core.Single

class FirebaseAuthDataSource() : AuthenticationDataSource {
    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun login(email: String, password: String): Single<User> = Single.create { emitter ->
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener() {
                val user = firebaseAuth.currentUser
                emitter.onSuccess(User(user?.uid, user?.displayName, user?.photoUrl.toString(),user?.email.toString()))
            }
            .addOnFailureListener {
                emitter.onError(it)
            }
    }

    override fun register(email: String, password: String): Single<User> =
        Single.create { emitter ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener() {
                    val user = firebaseAuth.currentUser
                    emitter.onSuccess(User(user?.uid, user?.displayName, user?.photoUrl.toString(),user?.email.toString()))

                }
                .addOnFailureListener {
                    emitter.onError(it)
                }
        }

    override fun logOut(): Single<Unit> = Single.create { emitter ->
        emitter.onSuccess(firebaseAuth.signOut())

    }
}