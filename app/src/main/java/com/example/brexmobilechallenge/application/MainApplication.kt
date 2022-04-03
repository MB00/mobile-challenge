package com.example.brexmobilechallenge.application

import android.app.Activity
import android.app.Application
import com.example.brexmobilechallenge.inject.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        initDaggerAppComponent()
        initTimber()
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    private fun initDaggerAppComponent() {
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

}