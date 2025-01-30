package com.example.demo.repository

import com.example.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Long> {
    @EntityGraph(attributePaths = ["category"])

    fun findByOrderByNameAsc(): List<Product>
    fun findByOrderByNameDesc(): List<Product>
    fun findByOrderByPriceAsc(): List<Product>
    fun findByOrderByPriceDesc(): List<Product>

    @Query("SELECT p FROM Product p WHERE LOWER(p.category.name) = LOWER(:categoryName)")
    fun findProductsByCategoryName(@Param("categoryName") categoryName: String): List<Product>
}