package com.droid.android.imagedownloader.repository

import com.droid.android.model.Image
import io.reactivex.Single

interface ImageListRepository {
    fun fetchImage(): Single<List<Image>>
}