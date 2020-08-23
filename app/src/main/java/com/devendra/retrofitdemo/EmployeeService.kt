package com.devendra.retrofitdemo

import retrofit2.Response
import retrofit2.http.GET

interface EmployeeService {

    @GET("325512ea-9fd0-4aeb-9cf5-cfda5c96f7a0")
    suspend fun getEmp() : Response<Employee>
}