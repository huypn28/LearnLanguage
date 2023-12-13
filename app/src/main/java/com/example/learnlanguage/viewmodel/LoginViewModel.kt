package com.example.learnlanguage.viewmodel


import com.example.learningenglish.firebase.FirebaseAuthenticationManager
import com.example.learnlanguage.base.BaseViewModel

class LoginViewModel: BaseViewModel() {
    private val firebaseAuthManager = FirebaseAuthenticationManager

    fun register(email: String,
               password: String,
               onSuccess: (() -> Unit) = {},
               onFail: ((String) -> Unit) = {}) {
        firebaseAuthManager.signUpWithEmailAndPassword(email, password, onSuccess, onFail)
    }

    fun login(email: String,
               password: String,
               onSuccess: (() -> Unit) = {},
               onFail: ((String) -> Unit) = {}) {
        firebaseAuthManager.signInWithEmailAndPassword(email, password, onSuccess, onFail)
    }

    fun isUserEmailVerified() = firebaseAuthManager.isMailVerified()

    fun sendResetPassword(email: String, onSuccess: (() -> Unit) = {}, onFail: ((String) -> Unit) = {}) {
        firebaseAuthManager.sendResetMail(email, onSuccess, onFail)
    }
}