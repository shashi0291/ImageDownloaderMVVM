package com.droid.android.imagedownloader.repository

import android.annotation.SuppressLint
import android.util.Log
import com.droid.android.imagedownloader.service.ImageService
import com.droid.android.imagedownloader.model.Image
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class ImageListRepositoryImpl @Inject constructor(private val imageService: ImageService) :
    ImageListRepository {

    private val _imageListSubject = BehaviorSubject.create<List<Image>>()

    @SuppressLint("CheckResult")
    override fun init() {
        imageService.fetchImageList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    // success
                    _imageListSubject.onNext(it)
                }, {
                    // failure
                    Log.d(ImageListRepositoryImpl::class.java.name, "error $it")
                    _imageListSubject.onError(it)
                }
            )
    }

    override fun getImageFromCacheOrInit(): Observable<List<Image>> {
        if (!_imageListSubject.hasValue()) {
            init()
        }
        return getImageFromCache()
    }

    override fun getImageFromCache(): Observable<List<Image>> {
        return _imageListSubject.toSerialized().subscribeOn(Schedulers.io())
    }
}