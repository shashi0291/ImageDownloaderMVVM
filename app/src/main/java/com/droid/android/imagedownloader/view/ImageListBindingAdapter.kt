package com.droid.android.imagedownloader.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("setThumbnailImage")
fun setThumbnailImage(view: ImageView, url: String?) {
    url?.let {
        // !!! IMPORTANT - the certificate of the hosting site has expired and hence image can't be downloaded using picasso
//            Picasso.get().load(url).into(binding.thumbnailImageView)

        // !!!! IMPORTANT - hardcoded one URL because of above issue (just for demo purpose)
        Picasso.get().load("https://farm6.staticflickr.com/5294/5460063960_1ef2d5c216_o.jpg").into(view)
    }
}