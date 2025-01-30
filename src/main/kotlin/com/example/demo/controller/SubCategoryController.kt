package com.example.demo.controller

import com.example.demo.model.SubCategory
import com.example.demo.service.SubCategoryService
import com.example.demo.common.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid
import org.springframework.dao.DataAccessException

@RestController
@RequestMapping("/api/v1/subcategories")
class SubCategoryController (private val subCategoryService: SubCategoryService) {

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
    fun bulkAddSubCategories(@RequestBody @Valid subCategories: List<SubCategory>): ResponseEntity<Map<String, String>> {
        val savedSubCategories = subCategoryService.bulkAddSubCategories(subCategories)
        return ResponseEntity.ok(mapOf("message" to "SubCategories added successfully", "count" to savedSubCategories.size.toString()))
    }

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