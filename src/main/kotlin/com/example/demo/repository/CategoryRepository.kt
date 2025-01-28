package com.example.demo.repository

import com.example.demo.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CategoryRepository : JpaRepository<Category, Long> 
// {
//     @Query("SELECT c FROM Category c LEFT JOIN FETCH c.products")
//     fun findAllWithProducts(): List<Category>
// }
