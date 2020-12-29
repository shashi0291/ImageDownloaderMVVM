package com.droid.android.imagedownloader.repository

import com.droid.android.imagedownloader.service.ImageService
import com.droid.android.model.Image
import io.reactivex.Single
import javax.inject.Inject

class ImageListRepositoryImpl @Inject constructor(val imageService: ImageService) : ImageListRepository {
    override fun fetchImage(): Single<List<Image>> {
        return imageService.fetchImageList()
    }
}