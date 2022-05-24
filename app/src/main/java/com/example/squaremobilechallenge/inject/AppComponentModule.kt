package com.example.squaremobilechallenge.inject

import android.app.Application
import com.example.squaremobilechallenge.application.MainApplication
import com.example.logic.inject.NetworkModule
import com.example.logic.inject.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainApplication)
}