package com.example.logic.repository

import com.example.logic.model.EmployeeResult
import io.reactivex.Single

interface ApiDataRepository {
    fun getEmployees(): Single<EmployeeResult>
}