package com.example.learnlanguage.model

data class User(
    val userName: String,
    val address: String,
    val birth: String,
    val imagePath: String="",
){
    constructor():this("","","","")
}