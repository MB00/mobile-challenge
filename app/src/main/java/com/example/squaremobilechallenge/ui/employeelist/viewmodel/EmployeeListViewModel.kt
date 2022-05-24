package com.example.squaremobilechallenge.ui.employeelist.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import com.example.squaremobilechallenge.ui.employeelist.interactor.EmployeeListInteractor
import com.example.squaremobilechallenge.ui.employeelist.router.EmployeeListRouter
import com.example.commonui.base.BaseViewModel
import com.example.commonui.extensions.disposedBy
import com.example.logic.model.Employee
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class EmployeeListViewModel (
    interactor: EmployeeListInteractor,
    router: EmployeeListRouter
) : BaseViewModel<EmployeeListInteractor, EmployeeListRouter>(interactor, router) {

    val isLoading = ObservableBoolean(false)
    val isDataLoaded = ObservableBoolean(false)
    val isEmpty = ObservableBoolean(false)
    val isError = ObservableBoolean(false)
    val employeeList = ObservableArrayList<Employee>()

    init {
        getEmployees()
    }

    fun getEmployees() {
        isLoading.set(true)
        interactor.getEmployees()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    employeeList.clear()
                    employeeList.addAll(it.employees.sortedBy { it.fullName })

                    isLoading.set(false)
                    isDataLoaded.set(true)
                    isEmpty.set(employeeList.isEmpty() || invalidateMalformedResponses())
                },
                onError = {
                    isError.set(true)
                    isLoading.set(false)
                }
            )
            .disposedBy(disposables)
    }

    fun invalidateMalformedResponses(): Boolean {
        for (employee in employeeList) {
            for (field in employee.javaClass.declaredFields) {
                field.isAccessible = true
                if (field.get(employee) == null) {
                    return true
                }
            }
        }
        return false
    }

}
