package com.example.logic.inject

import com.example.logic.provider.ApiDataProvider
import com.example.logic.repository.ApiDataRepository
import com.example.logic.repository.ApiDataRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideApiDataRepository(dataProvider: ApiDataProvider): ApiDataRepository {
        return ApiDataRepositoryImpl(dataProvider)
    }

}