package com.example.demo.service

import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import java.util.Optional

@Service
class ProductService @Autowired constructor(private val productRepository: ProductRepository) {
    fun addProduct(product: Product): Product = productRepository.save(product)

    fun getProducts(sortBy: String?, sortOrder: String?): List<Product> {
        return when (sortBy?.lowercase()) {
            "name" -> when (sortOrder?.lowercase()) {
                "asc" -> productRepository.findByOrderByNameAsc()
                "desc" -> productRepository.findByOrderByNameDesc()
                else -> productRepository.findByOrderByNameAsc()
            }
            "price" -> when (sortOrder?.lowercase()) {
                "asc" -> productRepository.findByOrderByPriceAsc()
                "desc" -> productRepository.findByOrderByPriceDesc()
                else -> productRepository.findByOrderByPriceAsc()
            }
            else -> productRepository.findByOrderByNameAsc()
        }
    }

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