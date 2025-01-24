package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(private val productRepository: ProductRepository) {
    fun addProduct(product: Product): Product = productRepository.save(product)

    fun getAllProducts(): List<Product> = productRepository.findAll()

    fun getProductById(id: Long): Product? = productRepository.findById(id).orElse(null)

    fun deleteProductById(id: Long) = productRepository.deleteById(id)

    fun updateProductById(id: Long, product: Product) = productRepository.save(product)
}