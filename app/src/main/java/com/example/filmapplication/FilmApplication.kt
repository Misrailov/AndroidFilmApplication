package com.example.filmapplication

import android.app.Application
import com.example.filmapplication.data.AppContainer
import com.example.filmapplication.data.DefaultAppContainer

class FilmApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}