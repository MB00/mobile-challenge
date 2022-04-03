package com.example.brexmobilechallenge.ui.categorylist.interactor

import com.example.logic.model.UserCategory
import io.reactivex.Single

interface CategoryListInteractor {
    fun getCategories(): Single<List<UserCategory>>
}