package com.example.brexmobilechallenge.ui.transactionlist.interactor

import com.example.logic.repository.ApiDataRepository

class TransactionListInteractorImpl(
    private val apiDataRepository: ApiDataRepository
) : TransactionListInteractor {

    override fun getTransactions() = apiDataRepository.getTransactions()

}