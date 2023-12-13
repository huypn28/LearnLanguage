package com.example.learnlanguage.di

import android.content.Context
import android.location.LocationManager
import com.example.learnlanguage.database.AppDatabase
import com.example.learnlanguage.viewmodel.LoginViewModel
import com.example.learnlanguage.viewmodel.MainViewModel
import com.example.learnlanguage.viewmodel.ProfileViewModel
import com.example.learnlanguage.viewmodel.EditProfileViewModel
import com.example.learnlanguage.viewmodel.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinModule = module {
        single { AppDatabase.invoke(androidContext()) }
        factory { androidContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager }
        viewModel { MainViewModel() }
        viewModel { SplashViewModel() }
        viewModel { LoginViewModel() }
        viewModel { ProfileViewModel() }
        viewModel { EditProfileViewModel() }
}