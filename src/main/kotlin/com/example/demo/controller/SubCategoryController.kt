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
// import com.example.demo.dto.CategoryDTO
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
        val savedSubCategory = subCategoryService.addSubCategory(subCategory)
        return ResponseEntity.ok(mapOf("message" to "SubCategory added successfully", "id" to savedSubCategory.id.toString()))
    }

    @PostMapping("/bulk-create")
    fun bulkAddSubCategories(@RequestBody @Valid subCategories: List<BulkSubCategoryDTO>): ResponseEntity<Map<String, String>> {
        val savedSubCategories = subCategoryService.bulkAddSubCategories(subCategories)
        return ResponseEntity.ok(mapOf("message" to "SubCategories added successfully", "count" to savedSubCategories.size.toString()))
    }

    // //seed the data
    // @PostMapping("/seed")
    // fun seedSubCategories(): ResponseEntity<Map<String, String>> {

    //     val categories = categoryRepository.findAllById(listOf(1L, 2L, 3L, 4L)).associateBy { it.id }

    //     val subCategories = listOf(
    //         BulkSubCategoryDTO(name = "Fruits", category = categories[1]),
    //         BulkSubCategoryDTO(name = "Vegetables", category = categories[1]),
    //         BulkSubCategoryDTO(name = "Herb & Spices", category = categories[1]),
    //         BulkSubCategoryDTO(name = "Milk & Milk Alternatives", category = categories[2]),
    //         BulkSubCategoryDTO(name = "Cheese & Butter", category = categories[2]),
    //         BulkSubCategoryDTO(name = "Yogurt & Cream", category = categories[2]),
    //         BulkSubCategoryDTO(name = "Poultry", category = categories[3]),
    //         BulkSubCategoryDTO(name = "Red Meat", category = categories[3]),
    //         BulkSubCategoryDTO(name = "Seafood", category = categories[3]),
    //         BulkSubCategoryDTO(name = "Processed Meats", category = categories[3]),
    //         BulkSubCategoryDTO(name = "Bread", category = categories[4]),
    //         BulkSubCategoryDTO(name = "Pastries & Desserts", category = categories[4]),
    //         BulkSubCategoryDTO(name = "Tortillas & Wraps", category = categories[4])
    //     )
    //     subCategoryService.bulkAddSubCategories(subCategories)
    //     return ResponseEntity.ok(mapOf("message" to "SubCategories seeded successfully"))
    // }

    @PutMapping("/{id}")
    fun updateSubCategoryById(@PathVariable("id") @Valid id: Long, @RequestBody subCategory: SubCategory): ResponseEntity<Map<String, String>> {
        val updatedSubCategory = subCategoryService.updateSubCategoryById(id, subCategory)
        return if (updatedSubCategory != null) {
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