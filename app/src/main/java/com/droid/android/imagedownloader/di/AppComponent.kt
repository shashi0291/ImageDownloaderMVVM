package com.droid.android.imagedownloader.di

import com.droid.android.imagedownloader.imageList.view.ImageListFragment
import com.droid.android.imagedownloader.repository.ImageListRepository
import com.droid.android.imagedownloader.view.MainActivity
import com.droid.android.imagedownloader.imageList.viewmodel.ImageListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent {
    fun inject(imageListRepository: ImageListRepository)
    fun inject(imageListViewModel: ImageListViewModel)
    fun inject(mainActivity: MainActivity)
    fun inject(viewModelProviderFactory: ViewModelProviderFactory)
    fun inject(fragment: ImageListFragment)
}