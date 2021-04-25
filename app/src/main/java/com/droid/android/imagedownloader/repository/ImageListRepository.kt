package com.droid.android.imagedownloader.repository

import com.droid.android.imagedownloader.model.Image
import io.reactivex.Observable

interface ImageListRepository {
    fun init()
    fun getImageFromCacheOrInit(): Observable<List<Image>>
    fun getImageFromCache(): Observable<List<Image>>
}