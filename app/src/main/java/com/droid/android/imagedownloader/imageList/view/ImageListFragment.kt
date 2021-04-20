package com.droid.android.imagedownloader.imageList.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.droid.android.imagedownloader.R
import com.droid.android.imagedownloader.databinding.FragmentImageListBinding
import com.droid.android.imagedownloader.di.ViewModelProviderFactory
import com.droid.android.imagedownloader.imageDetail.view.ImageDetailFragment
import com.droid.android.imagedownloader.imageList.viewmodel.ImageListViewModel
import com.droid.android.imagedownloader.imageList.viewmodel.ImageListViewModelImpl
import com.droid.android.imagedownloader.view.ImageListAdapter
import kotlinx.android.synthetic.main.activity_main.view.*

class ImageListFragment : Fragment() {

    lateinit var imageListViewModel: ImageListViewModel
    lateinit var binding: FragmentImageListBinding
    lateinit var imageListAdapter: ImageListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageListBinding.inflate(inflater, container, false)
        val view = binding.root
        imageListViewModel = ViewModelProviders.of(this, ViewModelProviderFactory()).get(
            ImageListViewModelImpl::class.java
        )
        imageListViewModel.fetchImageList()
        setView()
        setObservers()
        return view
    }

    private fun setView() {
        binding.apply {
            imageListRecyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        }
    }

    private fun setObservers() {
        imageListViewModel.imageListLiveData.observe(this, Observer {
            imageListAdapter = ImageListAdapter(it.toMutableList(), ::onImageItemClicked)
            binding.imageListRecyclerView.adapter = imageListAdapter
        })

        imageListViewModel.errorLiveData.observe(this, Observer {
            // handle error case here - display alert based on use case
        })
    }

    private fun onImageItemClicked(id: Int) {
        Log.d("TAG", "Item ID $id")
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, ImageDetailFragment.newInstance(id))
        transaction.addToBackStack(ImageListFragment::class.java.name)
        transaction.commit()
    }
}

