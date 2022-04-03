package com.example.logic.inject

import android.content.Context
import com.example.logic.provider.ApiDataProvider
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    internal fun provideHttpCache(context: Context): Cache {
        val httpCacheDirectory = File(context.cacheDir, "httpCache")
        return Cache(httpCacheDirectory, (10 * 1024 * 1024).toLong())
    }

    @Named("default")
    @Provides
    @Singleton
    internal fun provideOkHttpClientBuilder(cache: Cache): OkHttpClient.Builder {
        return createDefaultOkHttpClientBuilder(cache)
    }

    private fun createDefaultOkHttpClientBuilder(cache: Cache): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
        okHttpClientBuilder.connectTimeout(10, TimeUnit.SECONDS)
        okHttpClientBuilder.cache(cache)

        return okHttpClientBuilder
    }

    @Provides
    @Singleton
    internal fun provideDataProvider(
        @Named("default") okHttpClientBuilder: OkHttpClient.Builder,
        gson: Gson
    ): ApiDataProvider {
        return ApiDataProvider(okHttpClientBuilder, gson)
    }

}