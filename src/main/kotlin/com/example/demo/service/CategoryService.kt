package com.example.demo.service

import com.example.demo.model.Category
import com.example.demo.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService (private val categoryRepository: CategoryRepository) {

    fun getCategories(): List<Category> = categoryRepository.findAll()

    fun getCategoryById(id: Long): Category? = categoryRepository.findById(id).orElse(null)

    fun addCategory(category: Category): Category = categoryRepository.save(category)

    fun updateCategoryById(id: Long, category: Category): Category? {
        val existingCategory = categoryRepository.findById(id).orElse(null)
        return if (existingCategory == null) {
            Optional.empty()
        } else {
            val updatedCategory = category.copy(id = existingCategory.id)
            categoryRepository.save(updatedCategory)
            Optional.of(updatedCategory)
        }
    }

    fun deleteCategoryById(id: Long) = categoryRepository.deleteById(id)
}