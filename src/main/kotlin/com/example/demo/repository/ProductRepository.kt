package com.example.demo.repository

import com.example.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Query

interface ProductRepository : JpaRepository<Product, Long> {
    // @EntityGraph(attributePaths = ["category"])

    fun findByOrderByNameAsc(): List<Product>
    fun findByOrderByNameDesc(): List<Product>
    fun findByOrderByPriceAsc(): List<Product>
    fun findByOrderByPriceDesc(): List<Product>

    @Query("SELECT p FROM Product p WHERE p.category_id = :categoryId")
    fun findProductsByCategoryId(@Param("categoryId") categoryId: Long): List<Product>

    @Query("SELECT p FROM Product p WHERE p.subcategory_id = :subcategoryId")
    fun findProductsBySubcategoryId(@Param("subcategoryId") subcategoryId: Long): List<Product>
}