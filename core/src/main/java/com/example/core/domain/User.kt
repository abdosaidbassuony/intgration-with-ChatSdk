package com.example.core.domain


data class User(
    val uid: String?,
    val name: String?,
    val urlImage: String?,
    val email:String?
){
    fun toMap():Map<String,Any?>{
        return mapOf(
            "id" to uid,
            "userName" to name,
            "email" to email,
            "urlImagePicture" to urlImage
        )
    }
}