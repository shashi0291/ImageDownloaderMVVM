package com.droid.android.imagedownloader.di.imageList

import com.droid.android.imagedownloader.service.ImageService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ImageListServiceModule {

    @Provides
    internal fun provideAuthService(retrofit: Retrofit): ImageService {
        return retrofit.create(ImageService::class.java)
    }
}