package com.example.logic.provider

import com.example.logic.api.ApiClient
import com.example.logic.base.RestClientProvider
import com.google.gson.Gson
import okhttp3.OkHttpClient

class ApiDataProvider(okHttpClientBuilder: OkHttpClient.Builder, gson: Gson) :
    RestClientProvider<ApiClient>(okHttpClientBuilder, gson) {

    override fun clientClass(): Class<*> {
        return ApiClient::class.java
    }

}