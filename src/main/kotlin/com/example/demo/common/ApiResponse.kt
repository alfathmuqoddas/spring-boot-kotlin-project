package com.example.demo.common

data class ApiResponse(
    val success: Boolean,
    val message: String,
    val data: Map<String, Any>? = null,
    val error: String? = null
)