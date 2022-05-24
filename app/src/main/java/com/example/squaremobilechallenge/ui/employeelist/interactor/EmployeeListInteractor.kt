package com.example.squaremobilechallenge.ui.employeelist.interactor

import com.example.logic.model.EmployeeResult
import io.reactivex.Single

interface EmployeeListInteractor {
    fun getEmployees(): Single<EmployeeResult>
}