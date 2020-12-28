package com.droid.android.imagedownloader.di.imageList

import com.droid.android.imagedownloader.repository.ImageListRepository
import com.droid.android.imagedownloader.repository.ImageListRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ImageListRepositoryModule {

    @Binds
    abstract fun provideImageListRepository(imageListRepositoryImpl: ImageListRepositoryImpl): ImageListRepository
}