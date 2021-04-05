package com.droid.android.imagedownloader.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.droid.android.imagedownloader.R
import com.droid.android.imagedownloader.databinding.ActivityMainBinding
import com.droid.android.imagedownloader.di.ViewModelProviderFactory
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageListViewModel
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageListViewModelImpl

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var imageListViewModel: ImageListViewModel
    lateinit var binding: ActivityMainBinding
    lateinit var imageListAdapter: ImageListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(toolbar)
        imageListViewModel = ViewModelProviders.of(this, ViewModelProviderFactory()).get(
            ImageListViewModelImpl::class.java)
        imageListViewModel.fetchImageList()
        setView()
        setObservers()
    }

    private fun setObservers() {
        imageListViewModel.imageListLiveData.observe(this, Observer {
            imageListAdapter = ImageListAdapter(it.toMutableList())
            binding.imageListRecyclerView.adapter = imageListAdapter
        })

        imageListViewModel.errorLiveData.observe(this, Observer {
            // handle error case here - display alert based on use case
        })
    }

    private fun setView() {
        binding.apply {
            imageListRecyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        }

    }
}
