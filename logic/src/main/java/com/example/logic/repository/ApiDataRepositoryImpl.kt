package com.example.logic.repository

import com.example.logic.api.ApiClient
import com.example.logic.provider.ApiDataProvider

class ApiDataRepositoryImpl(
    private val apiDataProvider: ApiDataProvider
) : ApiDataRepository {

    private val apiClient: ApiClient by lazy {
        apiDataProvider.createClient()
    }

    override fun getEmployees() = apiClient.getEmployees()

}