package com.example.logic.api

import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    /*
      | resource                    | description                       |
|:----------------------------|:----------------------------------|
| `GET /rest/transactions`      | returns all transactions |
| `GET /rest/transactions/{id}`      | returns transaction with `id` |
| `GET /rest/categories`      | returns all user categories |
| `GET /rest/categories/{id}`      | returns user category with `id` |
| `PUT /rest/transactions/{id}`| updates transaction with `id` <br> <pre lang="json">{<br>  "userCategoryId": "id4cmsxks3" <br>}</pre> |
     */

    @GET("rest/transactions")
    fun getTransactions(): Single<List<Transaction>>

    @GET("rest/transactions/{id}")
    fun getTransactionDetails(transactionId: String): Single<Transaction>

    @GET("rest/categories")
    fun getCategories(): Single<List<UserCategory>>

    @GET("rest/categories/{id}")
    fun getCategoryDetails(categoryId: String): Single<UserCategory>

}