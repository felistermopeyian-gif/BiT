package com.example.studentmanagementapp.model

data class RemoteUser(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val website: String,
    val company: Company
)

data class Company(
    val name: String
)
