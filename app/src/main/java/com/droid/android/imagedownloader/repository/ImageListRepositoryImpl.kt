package com.droid.android.imagedownloader.repository

import android.util.Log
import com.droid.android.imagedownloader.service.ImageService
import com.droid.android.model.Image
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class ImageListRepositoryImpl @Inject constructor(private val imageService: ImageService) :
    ImageListRepository {

    val imageListSubject = BehaviorSubject.create<List<Image>>()

    override fun init() {
        imageService.fetchImageList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    // success
                    imageListSubject.onNext(it)
                }, {
                    // failure
                    Log.d("", "error" + it)
                    imageListSubject.onError(it)
                }
            )
    }

    override fun getImageFromCacheOrInit(): Observable<List<Image>> {
        if (!imageListSubject.hasValue()) {
            init()
        }
        return getImageFromCache()
    }

    override fun getImageFromCache(): Observable<List<Image>> {
        return imageListSubject.toSerialized().subscribeOn(Schedulers.io())
    }
}