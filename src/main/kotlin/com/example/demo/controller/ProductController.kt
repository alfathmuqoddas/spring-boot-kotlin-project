package com.example.demo.controller

import com.example.demo.model.Product
import com.example.demo.dto.ProductDTO
import com.example.demo.service.ProductService
import com.example.demo.common.productsBulk
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/v1/products")
class ProductController (private val productService: ProductService) {

    @GetMapping
    fun getProducts(
        @RequestParam(value = "sortOrder", required = false) sortOrder: String?,
        @RequestParam(value = "sortBy", required = false) sortBy: String?
    ): List<Product> {
        return productService.getProducts(sortBy, sortOrder)
    }

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): ResponseEntity<Any> {
        val product = productService.getProductById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "Product not found"))
        }
    }

    @GetMapping("/category/{categoryId}")
    fun getProductsByCategoryName(@PathVariable categoryId: Long): ResponseEntity<Any> {
        val products = productService.getProductsByCategoryId(categoryId)
        return if (products.isNotEmpty()) {
            ResponseEntity.ok(products)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "No products found"))
        }
    }

    @GetMapping("/subcategory/{subcategoryId}")
    fun getProductsBySubcategoryId(@PathVariable subcategoryId: Long): ResponseEntity<Any> {
        val products = productService.getProductsBySubcategoryId(subcategoryId)
        return if (products.isNotEmpty()) {
            ResponseEntity.ok(products)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "No products found"))
        }
    }

    @PostMapping
    fun addProduct(@RequestBody @Valid product: Product): ResponseEntity<Map<String, String>> {
        val savedProduct = productService.addProduct(product)
        return ResponseEntity.ok(mapOf("message" to "Product added successfully", "id" to savedProduct.id.toString()))
    }

    @PostMapping("/bulk-create")
    fun bulkAddProducts(@RequestBody @Valid products: List<ProductDTO>): ResponseEntity<Map<String, String>> {
        val savedProducts = productService.bulkAddProducts(products)
        return ResponseEntity.ok(mapOf("message" to "Products added successfully", "count" to savedProducts.size.toString()))
    }

    @PostMapping("/seed")
    fun seedProducts(): ResponseEntity<Map<String, String>> {
        productService.bulkAddProducts(productsBulk)
        return try {
            ResponseEntity.ok(mapOf("message" to "Products seeded successfully"))
        } catch (ex: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("message" to "Failed to seed products due to an unknown error"))
        }
        
    }
    
    @PutMapping("/{id}")
    fun updateProductById(@PathVariable("id") @Valid id: Long, @RequestBody product: Product): ResponseEntity<Map<String, String>> {
        val updatedProduct = productService.updateProductById(id, product)
        return if (updatedProduct != null) {
            ResponseEntity.ok(mapOf("message" to "Product updated successfully", "id" to id.toString()))
        } else {
            ResponseEntity.ok(mapOf("message" to "Product not found", "id" to id.toString()))
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id: Long): ResponseEntity<Map<String, String>> {
        productService.deleteProductById(id)
        return ResponseEntity.ok(mapOf("message" to "Product deleted successfully", "id" to id.toString()))
    }
}