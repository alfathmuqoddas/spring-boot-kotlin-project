package com.example.demo.dto

data class CategoryDTO(
    val id: Long,
    // val name: String
)

data class ProductDTO(
    val name: String,
    val price: Double,
    val quantity: Int,
    val category: CategoryDTO,
    val subcategory: SubCategoryDTO
)

data class SubCategoryDTO(
    val id: Long,
)

data class BulkCategoryDTO(
    val name: String,
)

data class BulkSubCategoryDTO(
    val name: String,
    val category: CategoryDTO
)