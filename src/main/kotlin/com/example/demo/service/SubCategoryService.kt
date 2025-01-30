com package com.example.demo.service

import com.example.demo.model.SubCategory
import com.example.demo.repository.SubCategoryRepository
import org.springframework.stereotype.Service

@Service
class SubCategoryService (private val subCategoryRepository: SubCategoryRepository) {

    fun getSubCategories(): List<SubCategory> = subCategoryRepository.findAll()

    fun getSubCategoryById(id: Long): SubCategory? = subCategoryRepository.findById(id).orElse(null)

    fun addSubCategory(subCategory: SubCategory): SubCategory = subCategoryRepository.save(subCategory)

    fun bulkAddSubCategories(subCategories: List<SubCategory>): List<SubCategory> {
        val subCategoryEntities = subCategories.map { SubCategory(name = it.name) }
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