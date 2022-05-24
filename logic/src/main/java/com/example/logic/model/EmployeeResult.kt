package com.example.logic.model

import com.google.gson.annotations.SerializedName

data class EmployeeResult(
    @SerializedName("employees") val employees: List<Employee>
)