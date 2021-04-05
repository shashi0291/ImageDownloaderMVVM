package com.droid.android.imagedownloader.imageDetail.viewmodel

import androidx.lifecycle.LiveData
import com.droid.android.model.Image

interface ImageListViewModel {
    val imageListLiveData: LiveData<List<Image>>
    val errorLiveData: LiveData<String>
    fun fetchImageList()
}