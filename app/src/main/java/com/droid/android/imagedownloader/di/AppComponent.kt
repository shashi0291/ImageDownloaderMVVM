package com.droid.android.imagedownloader.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        ActivityInjectorModule::class,
            ViewModelFactoryModule::class]
)
interface AppComponent {
}