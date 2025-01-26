package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import java.util.Optional

@Service
class ProductService @Autowired constructor(private val productRepository: ProductRepository) {
    fun addProduct(product: Product): Product = productRepository.save(product)

    fun getAllProducts(): List<Product> = productRepository.findAll()

    fun getProductById(id: Long): Product? = productRepository.findById(id).orElse(null)

    fun deleteProductById(id: Long) = productRepository.deleteById(id)

    fun updateProductById(id: Long, product: Product): Optional<Product> {
        val existingProduct = productRepository.findById(id).orElse(null)

        return if (existingProduct == null) {
            Optional.empty()
        } else {
            val updatedProduct = product.copy(id = existingProduct.id)
            productRepository.save(updatedProduct)
            Optional.of(updatedProduct)
        }
    }
}