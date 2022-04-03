package com.example.brexmobilechallenge.ui.categorylist.interactor

import com.example.logic.repository.ApiDataRepository

class CategoryListInteractorImpl(
    private val apiDataRepository: ApiDataRepository
) : CategoryListInteractor {

    override fun getCategories() = apiDataRepository.getCategories()
}