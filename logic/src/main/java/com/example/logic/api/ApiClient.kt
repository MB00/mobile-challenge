package com.example.logic.api

import com.example.logic.model.EmployeeResult
import io.reactivex.Single
import retrofit2.http.GET

interface ApiClient {

    @GET("employees.json")
    fun getEmployees(): Single<EmployeeResult>

}