package com.lalosapps.bookshelfapp

import android.app.Application
import com.lalosapps.bookshelfapp.di.AppContainer
import com.lalosapps.bookshelfapp.di.DefaultAppContainer

class BookshelfApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}