package com.droid.android.imagedownloader.repository

import com.droid.android.model.Image
import io.reactivex.Observable
import io.reactivex.Single

interface ImageListRepository {
    fun init()
    fun getImageFromCacheOrInit(): Observable<List<Image>>
    fun getImageFromCache(): Observable<List<Image>>
}