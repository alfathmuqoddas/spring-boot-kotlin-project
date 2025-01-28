package com.example.demo.dto

data class CategoryDTO(
    val id: Long,
    // val name: String
)

data class ProductDTO(
    val name: String,
    val price: Double,
    val quantity: Int,
    val category: CategoryDTO
)