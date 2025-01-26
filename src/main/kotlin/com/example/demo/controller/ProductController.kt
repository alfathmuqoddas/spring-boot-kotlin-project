package com.example.demo.controller

import com.example.demo.model.Product
import com.example.demo.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("/api/v1/products")
class ProductController @Autowired constructor(private val productService: ProductService) {
    @GetMapping("/")
    fun getAllProducts(): List<Product> = productService.getAllProducts()

    @GetMapping("/{id}")
    fun getProductById(@PathVariable id: Long): Product? = productService.getProductById(id)

    @PostMapping("/")
    fun addProduct(@RequestBody product: Product): ResponseEntity<Map<String, String>> {
        val savedProduct = productService.addProduct(product)
        return ResponseEntity.ok(mapOf("message" to "Product added successfully", "id" to savedProduct.id.toString()))
    }
    
    @PutMapping("/{id}")
    fun updateProductById(@PathVariable("id") id: Long, @RequestBody product: Product): ResponseEntity<Map<String, String>> {
        val updatedProduct = productService.updateProductById(id, product)
        return if (updatedProduct.isPresent) {
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