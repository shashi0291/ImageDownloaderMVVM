package com.droid.android.imagedownloader.imageDetail.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.droid.android.imagedownloader.databinding.FragmentImageDetailBinding
import com.droid.android.imagedownloader.databinding.FragmentImageListBinding
import com.droid.android.imagedownloader.di.ViewModelProviderFactory
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageDetailViewModel
import com.droid.android.imagedownloader.imageDetail.viewmodel.ImageDetailViewModelImpl

class ImageDetailFragment : Fragment() {

    lateinit var imageDetailViewModel: ImageDetailViewModel
    lateinit var binding: FragmentImageDetailBinding

    companion object {
        fun newInstance(id: Int): ImageDetailFragment {
            val bundle = Bundle()
            bundle.putInt("id", id)
            val imageDetailFragment = ImageDetailFragment()
            imageDetailFragment.arguments = bundle
            return imageDetailFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        imageDetailViewModel = ViewModelProviders.of(this, ViewModelProviderFactory()).get(
            ImageDetailViewModelImpl::class.java
        )
        arguments?.let {
            imageDetailViewModel.getImageById(it.getInt("id"))
        }
        setView()
        setObservers()
        return view
    }

    private fun setView() {
        binding.apply {
        }
    }

    private fun setObservers() {
        imageDetailViewModel.imageListLiveData.observe(this, Observer {
            Log.d("TAG", "URL = $it")
            binding.imageItem = it
        })

        imageDetailViewModel.errorLiveData.observe(this, Observer {
            // handle error case here - display alert based on use case
        })
    }
}

