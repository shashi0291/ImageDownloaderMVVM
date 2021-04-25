package com.droid.android.imagedownloader.imageDetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droid.android.imagedownloader.model.Image
import com.droid.android.imagedownloader.repository.ImageListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ImageDetailViewModelImpl @Inject constructor(private val imageListRepository: ImageListRepository) :
    ViewModel(),
    ImageDetailViewModel {

    private val _imageListMutableLiveData = MutableLiveData<Image>()
    private val _errorMutableLiveData = MutableLiveData<String>()

    override val imageListLiveData: LiveData<Image>
        get() = _imageListMutableLiveData
    override val errorLiveData: LiveData<String>
        get() = _errorMutableLiveData

    private val compositeDisposable = CompositeDisposable()

    override fun getImageById(id: Int) {
        compositeDisposable.add(
            imageListRepository.getImageFromCache()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let { imageList ->
                        if (!it.isNullOrEmpty()) {
                            imageList.firstOrNull { it.id == id }?.let { image ->
                                _imageListMutableLiveData.postValue(image)
                            }
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