package com.example.brexmobilechallenge.ui.transactiondetail.interactor

import com.example.logic.model.UserCategory
import com.example.logic.repository.ApiDataRepository
import io.reactivex.Single

class TransactionDetailInteractorImpl(
    private val apiDataRepository: ApiDataRepository
) : TransactionDetailInteractor {

    override fun getTransactionDetails(transactionId: String) = apiDataRepository.getTransactionDetails(transactionId)

    override fun getCategories() = apiDataRepository.getCategories()

    override fun getCategoryDetails(categoryId: String): Single<UserCategory> = apiDataRepository.getCategoryDetails(categoryId)

}