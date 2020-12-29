package com.droid.android.imagedownloader.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droid.android.imagedownloader.R
import com.droid.android.imagedownloader.databinding.ImageListRowItemBinding
import com.droid.android.model.Image
import com.squareup.picasso.Picasso

class ImageListAdapter constructor(private val imageList: MutableList<Image>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.image_list_row_item, parent, false
        ) as ImageListRowItemBinding
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).bind(imageList[position].thumbnailUrl)
//        (holder as ImageViewHolder).binding.thumbnailUrl = imageList[position].thumbnailUrl
    }

    class ImageViewHolder(val binding: ImageListRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            // !!! IMPORTANT - the certificate of the hosting site has expired and hence image can't be downloaded using picasso
//            Picasso.get().load(url).into(binding.thumbnailImageView)

            // !!!! IMPORTANT - hardcoded one URL because of above issue (just for demo purpose)
            Picasso.get().load("https://farm6.staticflickr.com/5294/5460063960_1ef2d5c216_o.jpg").into(binding.thumbnailImageView)
        }
    }
}