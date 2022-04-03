package com.example.brexmobilechallenge.ui.transaction.interactor

import com.example.logic.model.Transaction
import com.example.logic.model.UserCategory
import io.reactivex.Single

class TransactionInteractorImpl : TransactionInteractor {
    override fun getTransactions(): Single<List<Transaction>> {
        TODO("Not yet implemented")
    }

    override fun getTransactionDetails(transactionId: String): Single<Transaction> {
        TODO("Not yet implemented")
    }

    override fun getCategories(): Single<List<UserCategory>> {
        TODO("Not yet implemented")
    }

    override fun getCategoryDetails(categoryId: String): Single<UserCategory> {
        TODO("Not yet implemented")
    }
}