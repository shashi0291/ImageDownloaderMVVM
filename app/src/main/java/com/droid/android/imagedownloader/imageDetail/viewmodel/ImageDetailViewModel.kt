package com.droid.android.imagedownloader.imageDetail.viewmodel

import androidx.lifecycle.LiveData
import com.droid.android.model.Image

interface ImageDetailViewModel {
    val imageListLiveData: LiveData<String>
    val errorLiveData: LiveData<String>
    fun getImageById(id: Int)
}