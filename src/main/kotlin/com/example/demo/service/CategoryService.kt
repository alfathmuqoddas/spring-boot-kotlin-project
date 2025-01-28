package com.example.demo.service

import com.example.demo.model.Category
import com.example.demo.repository.CategoryRepository
import org.springframework.stereotype.Service


@Service
class CategoryService (private val categoryRepository: CategoryRepository) {

    fun getCategories(): List<Category> = categoryRepository.findAll()

    // fun getCategoriesWithProducts(): List<Category> = categoryRepository.findAllWithProducts()

    fun getCategoryById(id: Long): Category? = categoryRepository.findById(id).orElse(null)

    fun addCategory(category: Category): Category = categoryRepository.save(category)

    fun updateCategoryById(id: Long, category: Category): Category? {
        return categoryRepository.findById(id)
            .map { existingCategory ->
                val updatedCategory = existingCategory.copy(
                    name = category.name // Update other fields as needed
                )
                categoryRepository.save(updatedCategory)
            }
            .orElse(null)
    }

    fun deleteCategoryById(id: Long) = categoryRepository.deleteById(id)
}