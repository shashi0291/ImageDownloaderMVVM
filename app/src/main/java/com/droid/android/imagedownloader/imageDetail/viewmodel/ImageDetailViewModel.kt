package com.droid.android.imagedownloader.imageDetail.viewmodel

import androidx.lifecycle.LiveData
import com.droid.android.model.Image

interface ImageDetailViewModel {
    val imageListLiveData: LiveData<List<Image>>
    val errorLiveData: LiveData<String>
    fun fetchImageList()
}