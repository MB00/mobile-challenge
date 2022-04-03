package com.example.logic.repository

import com.example.logic.api.ApiClient
import com.example.logic.provider.ApiDataProvider

class ApiDataRepositoryImpl(
    private val apiDataProvider: ApiDataProvider
) : ApiDataRepository {

    private val apiClient: ApiClient by lazy {
        apiDataProvider.createClient()
    }

    override fun getTransactions() = apiClient.getTransactions()

    override fun getTransactionDetails(transactionId: String) = apiClient.getTransactionDetails(transactionId)

    override fun getCategories() = apiClient.getCategories()

    override fun getCategoryDetails(categoryId: String) = apiClient.getCategoryDetails(categoryId)

}