package com.example.demo.repository

import com.example.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long> {
    fun findByOrderByNameAsc(): List<Product>
    fun findByOrderByNameDesc(): List<Product>
    fun findByOrderByPriceAsc(): List<Product>
    fun findByOrderByPriceDesc(): List<Product>
}