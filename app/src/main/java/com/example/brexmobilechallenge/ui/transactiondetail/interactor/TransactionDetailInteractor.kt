package com.example.brexmobilechallenge.ui.transactiondetail.interactor

import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.Single

interface TransactionDetailInteractor {
    fun getTransactionDetails(transactionId: String): Single<Transaction>
    fun getCategories(): Single<List<UserCategory>>
    fun getCategoryDetails(categoryId: String): Single<UserCategory>
}