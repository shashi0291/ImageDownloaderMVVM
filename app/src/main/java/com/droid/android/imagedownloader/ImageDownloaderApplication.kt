package com.droid.android.imagedownloader

import android.app.Application
import com.droid.android.imagedownloader.di.AppComponent
import com.droid.android.imagedownloader.di.DaggerAppComponent

class ImageDownloaderApplication: Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}