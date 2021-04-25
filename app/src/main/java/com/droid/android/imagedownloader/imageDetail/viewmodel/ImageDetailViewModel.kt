package com.droid.android.imagedownloader.imageDetail.viewmodel

import androidx.lifecycle.LiveData
import com.droid.android.imagedownloader.model.Image

interface ImageDetailViewModel {
    val imageListLiveData: LiveData<Image>
    val errorLiveData: LiveData<String>
    fun getImageById(id: Int)
}