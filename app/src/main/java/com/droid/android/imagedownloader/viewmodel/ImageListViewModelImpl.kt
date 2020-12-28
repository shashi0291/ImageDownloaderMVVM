package com.droid.android.imagedownloader.viewmodel

import androidx.lifecycle.ViewModel
import com.droid.android.imagedownloader.repository.ImageListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ImageListViewModelImpl @Inject constructor(val imageListResository: ImageListRepository) : ViewModel(),
    ImageListViewModel {

    val compositeDisposable = CompositeDisposable()

    override fun fetchImageList() {
        compositeDisposable.add(imageListResository.fetchImage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({}, {})
        )
    }
}