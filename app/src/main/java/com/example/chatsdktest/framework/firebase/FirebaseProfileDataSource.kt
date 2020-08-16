package com.example.chatsdktest.framework.firebase

import com.example.core.data.profiledata.ProfileDataSource
import com.example.core.domain.User
import com.google.firebase.database.*
import io.reactivex.rxjava3.core.Single

class FirebaseProfileDataSource : ProfileDataSource {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference
    override fun updateUserInfo(user: User): Single<User> = Single.create { emitter ->
        database.child("USER").child(user.uid.toString()).setValue(user)
            .addOnSuccessListener {
                emitter.onSuccess(user)
            }
            .addOnFailureListener {
                emitter.onError(it)
            }
    }

    override fun getUserInfo(id: String?): Single<User> = Single.create { emitter ->
        database.child("USER").child(id!!)
        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                emitter.onError(error.toException())
            }
            override fun onDataChange(snapshot: DataSnapshot) {
                // what is best practice ?
                val name = snapshot.child("USER").child(id).child("name").value.toString()
                val email = snapshot.child("USER").child(id).child("email").value.toString()
                val imageUrl = snapshot.child("USER").child(id).child("urlImage").value.toString()
                emitter.onSuccess(User(name = name, email = email, urlImage = imageUrl, uid = id))

            }
        })
    }
}