package com.example.brexmobilechallenge.ui.transaction.interactor

import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.Single

interface TransactionInteractor {
    fun getTransactions(): Single<List<Transaction>>
    fun getTransactionDetails(transactionId: String): Single<Transaction>
    fun getCategories(): Single<List<UserCategory>>
    fun getCategoryDetails(categoryId: String): Single<UserCategory>
}