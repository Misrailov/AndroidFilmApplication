package com.example.filmapplication

import android.app.Application
import com.example.filmapplication.data.AppContainer
import com.example.filmapplication.data.DefaultAppContainer
/**
 * Custom Application class for the FilmApplication.
 */
class FilmApplication: Application() {
    /**
     * The container for managing dependencies and providing access to various application components.
     */
    lateinit var container: AppContainer
    /**
     * Called when the application is starting, before any other application objects have been created.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(context= applicationContext)
    }
}