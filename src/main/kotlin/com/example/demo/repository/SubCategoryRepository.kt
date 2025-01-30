package com.example.demo.repository

import com.example.demo.model.SubCategory
import org.springframework.data.jpa.repository.JpaRepository

interface SubCategoryRepository : JpaRepository<SubCategory, Long>