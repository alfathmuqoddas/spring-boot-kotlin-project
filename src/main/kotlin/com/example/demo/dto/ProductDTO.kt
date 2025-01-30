package com.example.demo.dto

data class CategoryDTO(
    val id: Long,
    // val name: String
)

data class ProductDTO(
    val name: String,
    val price: Double,
    val quantity: Int,
    val category_id: Long,
    val subcategory_id: Long
)

data class SubCategoryDTO(
    val id: Long,
)

data class BulkCategoryDTO(
    val name: String,
)

data class BulkSubCategoryDTO(
    val name: String,
    val category_id: Long
)