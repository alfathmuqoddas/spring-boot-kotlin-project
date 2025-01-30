package com.example.demo.service

import com.example.demo.dto.ProductDTO
import com.example.demo.model.Product
import com.example.demo.repository.ProductRepository
import com.example.demo.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ProductService (
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
) {
    
    fun addProduct(product: Product): Product = productRepository.save(product)

    fun bulkAddProducts(products: List<ProductDTO>): List<Product> {
        val categoryIds = products.map {it.category.id}.toSet()
        val categories = categoryRepository.findAllById(categoryIds).associateBy {it.id}
        
        val productEntities = products.map { 
            val category = categories[it.category.id] ?: throw IllegalArgumentException("Category with id ${it.category.id} not found")
            Product(name = it.name, price = it.price, quantity = it.quantity, category = category) 
        }
        return productRepository.saveAll(productEntities)
    }

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

    fun updateProductById(id: Long, product: Product): Product? {
        return productRepository.findById(id)
            .map { existingProduct ->
                val updatedProduct = existingProduct.copy(
                    name = product.name, // Update other fields as needed
                    price = product.price,
                    quantity = product.quantity
                )
                productRepository.save(updatedProduct)
            }
            .orElse(null)
    }

    fun getProductsByCategoryName(categoryName: String): List<Product> {
        return productRepository.findProductsByCategoryName(categoryName)
    }
}