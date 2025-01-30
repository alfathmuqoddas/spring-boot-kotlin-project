package com.example.demo.controller

import com.example.demo.model.Category
import com.example.demo.service.CategoryService
import com.example.demo.common.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid
import org.springframework.dao.DataAccessException
import com.example.demo.dto.CategoryDTO


@RestController
@RequestMapping("/api/v1/categories")
class CategoryController (private val categoryService: CategoryService) {

    @GetMapping
    fun getCategories(): ResponseEntity<ApiResponse> {
        return try {
            val categories = categoryService.getCategories()
            ResponseEntity.ok(
                ApiResponse(
                    success = true,
                    message = "Categories retrieved successfully",
                    data = mapOf("categories" to categories)
                )
            )
        } catch (ex: DataAccessException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to retrieve categories due to a database error",
                    error = ex.message
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to retrieve categories due to an unknown error",
                    error = ex.message
                )
            )
        }
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<ApiResponse> {
        return try {
            val category = categoryService.getCategoryById(id)
            if (category != null) {
                ResponseEntity.ok(
                    ApiResponse(
                        success = true,
                        message = "Category retrieved successfully",
                        data = mapOf("category" to category)
                    )
                )
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse(
                        success = false,
                        message = "Category not found"
                    )
                )
            }
        } catch (ex: DataAccessException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to retrieve category due to a database error",
                    error = ex.message
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to retrieve category due to an unknown error",
                    error = ex.message
                )
            )
        }
    }

    @PostMapping
    fun addCategory(@RequestBody @Valid category: Category): ResponseEntity<ApiResponse> {
        return try {
            val savedCategory = categoryService.addCategory(category)
            ResponseEntity.ok(
                ApiResponse(
                    success = true,
                    message = "Category added successfully",
                    data = null
                )
            )
        } catch (ex: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse(
                    success = false,
                    message = "Invalid input: ${ex.message}",
                    error = ex.message
                )
            )
        } catch (ex: DataAccessException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to add category due to a database error",
                    error = ex.message
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to add category due to an unknown error",
                    error = ex.message
                )
            )
        }
    }

    // //seed the data
    // @PostMapping("/seed")
    // fun seedCategories(): ResponseEntity<ApiResponse> {
    //     val categories = listOf(
    //         Category(name = "Fresh Produce"),
    //         Category(name = "Dairy & Eggs"),
    //         Category(name = "Meat & Seafood"),
    //         Category(name = "Bakery & Bread"),
    //         Category(name = "Frozen Foods"),
    //         Category(name = "Pantry Staples"),
    //         Category(name = "Snacks & Beverages"),
    //         Category(name = "Health & Organic Products"),
    //         Category(name = "Household Essentials"),
    //         Category(name = "Baby & Personal Care"),
    //     ): List<CategoryDTO>
    //     categoryService.bulkAddCategories(categories)
    //     return try {
    //         ResponseEntity.ok(
    //             ApiResponse(
    //                 success = true,
    //                 message = "Categories seeded successfully",
    //                 data = null
    //             )
    //         )
    //     } catch (ex: Exception) {
    //         ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
    //             ApiResponse(
    //                 success = false,
    //                 message = "Failed to seed categories due to an unknown error",
    //                 error = ex.message
    //             )
    //         )
    //     } catch (ex: DataAccessException) {
    //         ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
    //             ApiResponse(
    //                 success = false,
    //                 message = "Failed to seed categories due to a database error",
    //                 error = ex.message
    //             )
    //         )
    //     }
    // }

    @PutMapping("/{id}")
    fun updateCategoryById(
        @PathVariable("id") id: Long, 
        @RequestBody @Valid category: Category
    ): ResponseEntity<ApiResponse> {
        return try {
            val updatedCategory = categoryService.updateCategoryById(id, category)
            if (updatedCategory != null) {
                ResponseEntity.ok(
                    ApiResponse(
                        success = true,
                        message = "Category updated successfully",
                        data = null
                    )
                )
            } else {
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    ApiResponse(
                        success = false,
                        message = "Category not found",
                        data = null
                    )
                )
            }
        } catch (ex: DataAccessException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to update category due to a database error",
                    error = ex.message
                )
            )
        } catch (ex: IllegalArgumentException) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ApiResponse(
                    success = false,
                    message = "Invalid input: ${ex.message}",
                    error = ex.message
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to update category due to an unknown error",
                    error = ex.message
                )
            )
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCategoryById(@PathVariable id: Long): ResponseEntity<ApiResponse> {
        return try {
            val deletedCategory = categoryService.deleteCategoryById(id)
            ResponseEntity.ok(
                ApiResponse(
                    success = true,
                    message = "Category deleted successfully",
                    data = null
                )
            )
        } catch (ex: DataAccessException) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to delete category due to a database error",
                    error = ex.message
                )
            )
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ApiResponse(
                    success = false,
                    message = "Failed to delete category due to an unknown error",
                    error = ex.message
                )
            )
        }
    }
}