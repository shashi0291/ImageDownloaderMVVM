package com.droid.android.imagedownloader.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setThumbnailImage")
fun setThumbnailImage(view: ImageView, url: String?) {
    url?.let {
        Picasso.get().load(it).into(view)
    }
}