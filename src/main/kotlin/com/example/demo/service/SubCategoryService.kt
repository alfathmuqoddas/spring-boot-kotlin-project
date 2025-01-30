package com.example.demo.service

import com.example.demo.model.SubCategory
import com.example.demo.dto.BulkSubCategoryDTO
import com.example.demo.repository.SubCategoryRepository
import com.example.demo.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class SubCategoryService (
    private val subCategoryRepository: SubCategoryRepository, 
    private val categoryRepository: CategoryRepository
    
) {

    fun getSubCategories(): List<SubCategory> = subCategoryRepository.findAll()

    fun getSubCategoryById(id: Long): SubCategory? = subCategoryRepository.findById(id).orElse(null)

    fun addSubCategory(subCategory: SubCategory): SubCategory = subCategoryRepository.save(subCategory)

    fun bulkAddSubCategories(subCategories: List<BulkSubCategoryDTO>): List<SubCategory> {
        val categoryIds = subCategories.map {it.category_id}.toSet()
        val categories = categoryRepository.findAllById(categoryIds).associateBy {it.id}

        val subCategoryEntities = subCategories.map { 
            val category = categories[it.category_id] ?: throw IllegalArgumentException("Category with id ${it.category_id} not found")
            SubCategory(name = it.name, category_id = it.category_id) 
        }
        return subCategoryRepository.saveAll(subCategoryEntities)
    }

    fun updateSubCategoryById(id: Long, subCategory: SubCategory): SubCategory? {
        return subCategoryRepository.findById(id)
            .map { existingSubCategory ->
                val updatedSubCategory = existingSubCategory.copy(
                    name = subCategory.name // Update other fields as needed
                )
                subCategoryRepository.save(updatedSubCategory)
            }
            .orElse(null)
    }

    fun deleteSubCategoryById(id: Long) = subCategoryRepository.deleteById(id)
}