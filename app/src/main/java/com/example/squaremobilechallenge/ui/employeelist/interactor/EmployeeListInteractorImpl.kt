package com.example.squaremobilechallenge.ui.employeelist.interactor

import com.example.logic.repository.ApiDataRepository

class EmployeeListInteractorImpl(
    private val apiDataRepository: ApiDataRepository
) : EmployeeListInteractor {

    override fun getEmployees() = apiDataRepository.getEmployees()

}