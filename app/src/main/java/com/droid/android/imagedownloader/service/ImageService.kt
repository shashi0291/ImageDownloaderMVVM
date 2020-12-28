package com.droid.android.imagedownloader.service

import com.droid.android.model.ImageListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ImageService {

    @GET("/photos")
    fun fetchImageList(): Single<ImageListResponse>
}