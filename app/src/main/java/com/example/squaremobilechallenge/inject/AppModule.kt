package com.example.squaremobilechallenge.inject

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Module(includes = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AndroidTypesModule::class,
])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

}