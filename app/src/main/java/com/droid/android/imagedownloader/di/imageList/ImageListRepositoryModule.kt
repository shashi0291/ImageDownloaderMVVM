package com.droid.android.imagedownloader.di.imageList

import com.droid.android.imagedownloader.repository.ImageListRepositoryImpl
import com.droid.android.imagedownloader.service.ImageService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageListRepositoryModule {

    @Singleton
    @Provides
    fun provideImageListRepository(imageListService: ImageService): ImageListRepositoryImpl {
        return ImageListRepositoryImpl(imageListService)
    }
}