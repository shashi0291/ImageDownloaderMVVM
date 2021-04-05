package com.droid.android.imagedownloader.di.imageList

import androidx.lifecycle.ViewModel
import com.droid.android.imagedownloader.di.ViewModelKey
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageListViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ImageListViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ImageListViewModelImpl::class)
    abstract fun provideImageListViewModel(imageListViewModelImpl: ImageListViewModelImpl): ViewModel
}