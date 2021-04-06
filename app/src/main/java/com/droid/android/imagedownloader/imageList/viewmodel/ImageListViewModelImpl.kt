package com.droid.android.imagedownloader.imageList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droid.android.imagedownloader.repository.ImageListRepository
import com.droid.android.model.Image
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ImageListViewModelImpl @Inject constructor(private val ImageListRepository: ImageListRepository) : ViewModel(),
    ImageListViewModel {

    private val _imageListMutableLiveData = MutableLiveData<List<Image>>()
    private val _errorMutableLiveData = MutableLiveData<String>()

    override val imageListLiveData: LiveData<List<Image>>
        get() = _imageListMutableLiveData
    override val errorLiveData: LiveData<String>
        get() = _errorMutableLiveData

    val compositeDisposable = CompositeDisposable()

    override fun fetchImageList() {
        compositeDisposable.add(
            ImageListRepository.fetchImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let {
                        if (!it.isNullOrEmpty()) {
                            _imageListMutableLiveData.postValue(it)
                        } else {
                            _errorMutableLiveData.postValue("No Image Found")
                        }
                    }
                }, {
                    _errorMutableLiveData.postValue("No Image Found")
                })
        )
    }
}