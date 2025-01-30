package com.example.demo.dto

data class CategoryDTO(
    val id: Long,
    // val name: String
)

data class ProductDTO(
    val name: String,
    val price: Double,
    val quantity: Int,
    val categoryId: Long,
    val subcategoryId: Long
)

data class SubCategoryDTO(
    val id: Long,
)

data class BulkCategoryDTO(
    val name: String,
)

data class BulkSubCategoryDTO(
    val name: String,
    val categoryId: Long
)