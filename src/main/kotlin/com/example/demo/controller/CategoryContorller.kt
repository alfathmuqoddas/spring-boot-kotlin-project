pacakge com.example.demo.controller

import com.example.demo.model.Category
import com.example.demo.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api/v1/categories")
class CategoryController (private val categoryService: CategoryService) {

    @GetMapping
    fun getCategories(): List<Category> {
        return categoryService.getCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<Any> {
        val category = categoryService.getCategoryById(id)
        return if (category != null) {
            ResponseEntity.ok(category)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "Category not found"))
        }
    }

    @PostMapping
    fun addCategory(@RequestBody category: Category): ResponseEntity<Map<String, String>> {
        val savedCategory = categoryService.addCategory(category)
        return ResponseEntity.ok(mapOf("message" to "Category added successfully", "id" to savedCategory.id.toString()))
    }

    @PutMapping("/{id}")
    fun updateCategoryById(@PathVariable("id") id: Long, @RequestBody category: Category): ResponseEntity<Map<String, String>> {
        val updatedCategory = categoryService.updateCategoryById(id, category)
        return if (updatedCategory.isPresent) {
            ResponseEntity.ok(mapOf("message" to "Category updated successfully", "id" to id.toString()))
        } else {
            ResponseEntity.ok(mapOf("message" to "Category not found", "id" to id.toString()))
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCategoryById(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        categoryService.deleteCategoryById(id)
        return ResponseEntity.ok(mapOf("message" to "Category deleted successfully", "id" to id.toString()))
    }
}