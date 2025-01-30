package com.example.demo.controller

import com.example.demo.model.SubCategory
import com.example.demo.model.Category
import com.example.demo.service.SubCategoryService
import com.example.demo.common.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid
import org.springframework.dao.DataAccessException
import com.example.demo.dto.CategoryDTO
import com.example.demo.dto.BulkSubCategoryDTO
// import com.example.demo.repository.CategoryRepository

@RestController
@RequestMapping("/api/v1/subcategories")
class SubCategoryController (
    private val subCategoryService: SubCategoryService, 
    // private val categoryRepository: CategoryRepository
    
) {

    @GetMapping
    fun getSubCategories(): List<SubCategory> {
        return subCategoryService.getSubCategories()
    }

    @GetMapping("/{id}")
    fun getSubCategoryById(@PathVariable id: Long): SubCategory? {
        return subCategoryService.getSubCategoryById(id)
    }

    @PostMapping
    fun addSubCategory(@RequestBody @Valid subCategory: SubCategory): ResponseEntity<Map<String, String>> {
        val subCategoryEntity = subCategoryService.addSubCategory(subCategory)
        return ResponseEntity.ok(mapOf("message" to "SubCategory added successfully", "id" to subCategoryEntity.id.toString()))
    }

    @PostMapping("/bulk-create")
    fun bulkAddSubCategories(@RequestBody @Valid subCategories: List<BulkSubCategoryDTO>): ResponseEntity<Map<String, String>> {
        val savedSubCategories = subCategoryService.bulkAddSubCategories(subCategories)
        return ResponseEntity.ok(mapOf("message" to "SubCategories added successfully", "count" to savedSubCategories.size.toString()))
    }

    //seed the data
    @PostMapping("/seed")
    fun seedSubCategories(): ResponseEntity<Map<String, String>> {
        val subCategories = listOf(
            BulkSubCategoryDTO(name = "Fruits", categoryId = 1),
            BulkSubCategoryDTO(name = "Vegetables", categoryId = 1),
            BulkSubCategoryDTO(name = "Herb & Spices", categoryId = 1),
            BulkSubCategoryDTO(name = "Milk & Milk Alternatives", categoryId = 2),
            BulkSubCategoryDTO(name = "Cheese & Butter", categoryId = 2),
            BulkSubCategoryDTO(name = "Yogurt & Cream", categoryId = 2),
            BulkSubCategoryDTO(name = "Poultry", categoryId = 3),
            BulkSubCategoryDTO(name = "Red Meat", categoryId = 3),
            BulkSubCategoryDTO(name = "Seafood", categoryId = 3),
            BulkSubCategoryDTO(name = "Processed Meats", categoryId = 3),
            BulkSubCategoryDTO(name = "Bread", categoryId = 4),
            BulkSubCategoryDTO(name = "Pastries & Desserts", categoryId = 4),
            BulkSubCategoryDTO(name = "Tortillas & Wraps", categoryId = 4),
        )
        subCategoryService.bulkAddSubCategories(subCategories)
        return ResponseEntity.ok(mapOf("message" to "SubCategories seeded successfully"))
    }

    @PutMapping("/{id}")
    fun updateSubCategoryById(@PathVariable("id") @Valid id: Long, @RequestBody subCategory: SubCategory): ResponseEntity<Map<String, String>> {
        val updatedSubcategory = subCategoryService.updateSubCategoryById(id, subCategory)
        return if (updatedSubcategory != null) {
            ResponseEntity.ok(mapOf("message" to "SubCategory updated successfully", "id" to id.toString()))
        } else {
            ResponseEntity.ok(mapOf("message" to "SubCategory not found", "id" to id.toString()))
        }
    }

    @DeleteMapping("/{id}")
    fun deleteSubCategoryById(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        subCategoryService.deleteSubCategoryById(id)
        return ResponseEntity.ok(mapOf("message" to "SubCategory deleted successfully", "id" to id.toString()))
    }
}