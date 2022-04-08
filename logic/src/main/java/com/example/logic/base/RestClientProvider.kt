package com.example.logic.base

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class RestClientProvider<T>
protected constructor(
    private val okHttpClientBuilder: OkHttpClient.Builder,
    private val gson: Gson
) {

    protected open fun baseUrl(): String {
        return "http://192.168.1.214:4000"
    }

    protected abstract fun clientClass(): Class<*>

    @Suppress("UNCHECKED_CAST")
    fun createClient(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClientBuilder.build())
            .build()

        return retrofit.create(clientClass() as Class<Any>) as T
    }
}