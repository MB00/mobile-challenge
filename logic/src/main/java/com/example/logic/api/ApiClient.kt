package com.example.logic.api

import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("rest/transactions")
    fun getTransactions(): Single<List<Transaction>>

    @GET("rest/transactions/{id}")
    fun getTransactionDetails(@Path("id") transactionId: String): Single<Transaction>

    @GET("rest/categories")
    fun getCategories(): Single<List<UserCategory>>

    @GET("rest/categories/{id}")
    fun getCategoryDetails(@Path("id") categoryId: String): Single<UserCategory>

}