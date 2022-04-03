package com.example.brexmobilechallenge.ui.transactionlist.interactor

import com.example.logic.model.Transaction
import io.reactivex.Single

interface TransactionListInteractor {
    fun getTransactions(): Single<List<Transaction>>
}