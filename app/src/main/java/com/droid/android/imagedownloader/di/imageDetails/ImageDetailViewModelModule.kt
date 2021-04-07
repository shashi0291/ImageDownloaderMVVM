package com.droid.android.imagedownloader.di.imageDetails

import androidx.lifecycle.ViewModel
import com.droid.android.imagedownloader.di.ViewModelKey
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageDetailViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ImageDetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageDetailViewModelImpl::class)
    abstract fun provideImageDetailViewModel(imageDetailViewModelImpl: ImageDetailViewModelImpl): ViewModel
}