package com.devendra.retrofitdemo

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("employee_age")
    val employee_age: String,
    @SerializedName("employee_name")
    val employee_name: String,
    @SerializedName("employee_salary")
    val employee_salary: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("profile_image")
    val profile_image: String
)