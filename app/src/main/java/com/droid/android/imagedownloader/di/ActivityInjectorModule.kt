package com.droid.android.imagedownloader.di

import com.droid.android.imagedownloader.di.imageList.ImageListRepositoryModule
import com.droid.android.imagedownloader.di.imageList.ImageListServiceModule
import com.droid.android.imagedownloader.di.imageList.ImageListViewModelModule
import com.droid.android.imagedownloader.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {

    @ContributesAndroidInjector(
        modules = [ImageListRepositoryModule::class,
            ImageListViewModelModule::class,
            ImageListServiceModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}