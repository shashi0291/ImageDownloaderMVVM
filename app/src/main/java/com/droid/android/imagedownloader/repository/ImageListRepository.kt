package com.droid.android.imagedownloader.repository

import com.droid.android.model.ImageListResponse
import io.reactivex.Single

interface ImageListRepository {
    fun fetchImage(): Single<ImageListResponse>
}