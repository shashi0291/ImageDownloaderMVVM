package com.droid.android.imagedownloader.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.droid.android.imagedownloader.R
import com.droid.android.imagedownloader.databinding.ImageListRowItemBinding
import com.droid.android.model.Image

class ImageListAdapter constructor(
    private val imageList: MutableList<Image>,
    private val onImageItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.image_list_row_item, parent, false
        ) as ImageListRowItemBinding
        return ImageViewHolder(binding, onImageItemClicked)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ImageViewHolder).binding.thumbnailUrl = imageList[position].thumbnailUrl
        holder.itemView.setOnClickListener {
            holder.onImageItemClicked(imageList[position].id)
        }
    }

    class ImageViewHolder(val binding: ImageListRowItemBinding, val onImageItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    }
}