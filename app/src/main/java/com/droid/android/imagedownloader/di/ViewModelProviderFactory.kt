package com.droid.android.imagedownloader.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.droid.android.imagedownloader.ImageDownloaderApplication
import com.droid.android.imagedownloader.repository.ImageListRepository
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageListViewModelImpl

import javax.inject.Inject

class ViewModelProviderFactory : ViewModelProvider.Factory {

    lateinit var apiComponent: AppComponent
    @Inject
    lateinit var imageListRepository: ImageListRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        var apiComponent: AppComponent = ImageDownloaderApplication.appComponent
        apiComponent.inject(this)
        if (modelClass.isAssignableFrom(ImageListViewModelImpl::class.java)) {
            return ImageListViewModelImpl(
                imageListRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
