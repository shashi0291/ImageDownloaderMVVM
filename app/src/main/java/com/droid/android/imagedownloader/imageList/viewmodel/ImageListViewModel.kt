package com.droid.android.imagedownloader.imageList.viewmodel

import androidx.lifecycle.LiveData
import com.droid.android.imagedownloader.model.Image

interface ImageListViewModel {
    val imageListLiveData: LiveData<List<Image>>
    val errorLiveData: LiveData<String>
    fun fetchImageList()
}