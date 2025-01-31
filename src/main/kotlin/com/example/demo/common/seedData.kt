package com.example.demo.common

import com.example.demo.dto.ProductDTO

val productsBulk = listOf(
            // Fresh Produce - Fruits (Category ID: 1, Subcategory ID: 1)
            ProductDTO(name = "Apples", price = 1.99, quantity = 10, categoryId = 1, subcategoryId = 1),
            ProductDTO(name = "Bananas", price = 0.99, quantity = 15, categoryId = 1, subcategoryId = 1),
            ProductDTO(name = "Oranges", price = 1.49, quantity = 12, categoryId = 1, subcategoryId = 1),
            ProductDTO(name = "Grapes", price = 2.99, quantity = 8, categoryId = 1, subcategoryId = 1),
            ProductDTO(name = "Mangoes", price = 3.49, quantity = 6, categoryId = 1, subcategoryId = 1),

            // Fresh Produce - Vegetables (Category ID: 1, Subcategory ID: 2)
            ProductDTO(name = "Carrots", price = 1.29, quantity = 10, categoryId = 1, subcategoryId = 2),
            ProductDTO(name = "Tomatoes", price = 1.99, quantity = 8, categoryId = 1, subcategoryId = 2),
            ProductDTO(name = "Potatoes", price = 0.89, quantity = 20, categoryId = 1, subcategoryId = 2),
            ProductDTO(name = "Spinach", price = 1.79, quantity = 7, categoryId = 1, subcategoryId = 2),
            ProductDTO(name = "Onions", price = 1.49, quantity = 12, categoryId = 1, subcategoryId = 2),

            // Fresh Produce - Herbs & Spices (Category ID: 1, Subcategory ID: 3)
            ProductDTO(name = "Basil", price = 2.99, quantity = 5, categoryId = 1, subcategoryId = 3),
            ProductDTO(name = "Cilantro", price = 1.99, quantity = 6, categoryId = 1, subcategoryId = 3),
            ProductDTO(name = "Garlic", price = 0.79, quantity = 15, categoryId = 1, subcategoryId = 3),

            // Dairy & Eggs (Category ID: 2)
            ProductDTO(name = "Whole Milk", price = 4.49, quantity = 5, categoryId = 2, subcategoryId = 4),
            ProductDTO(name = "Almond Milk", price = 5.99, quantity = 5, categoryId = 2, subcategoryId = 4),
            ProductDTO(name = "Cheddar Cheese", price = 5.99, quantity = 3, categoryId = 2, subcategoryId = 5),
            ProductDTO(name = "Butter", price = 3.49, quantity = 4, categoryId = 2, subcategoryId = 5),
            ProductDTO(name = "Greek Yogurt", price = 3.99, quantity = 7, categoryId = 2, subcategoryId = 6),
            ProductDTO(name = "Heavy Cream", price = 2.99, quantity = 5, categoryId = 2, subcategoryId = 6),
            ProductDTO(name = "Organic Eggs", price = 4.99, quantity = 12, categoryId = 2, subcategoryId = 7),

            // Meat & Seafood (Category ID: 3)
            ProductDTO(name = "Chicken Breast", price = 6.99, quantity = 4, categoryId = 3, subcategoryId = 8),
            ProductDTO(name = "Beef Steak", price = 12.99, quantity = 3, categoryId = 3, subcategoryId = 9),
            ProductDTO(name = "Salmon Fillet", price = 9.99, quantity = 5, categoryId = 3, subcategoryId = 10),
            ProductDTO(name = "Smoked Ham", price = 7.49, quantity = 6, categoryId = 3, subcategoryId = 11),

            // Bakery & Bread (Category ID: 4)
            ProductDTO(name = "Whole Wheat Bread", price = 2.49, quantity = 10, categoryId = 4, subcategoryId = 12),
            ProductDTO(name = "Croissant", price = 1.99, quantity = 12, categoryId = 4, subcategoryId = 13),
            ProductDTO(name = "Corn Tortilla", price = 2.99, quantity = 15, categoryId = 4, subcategoryId = 14),

            // Frozen Foods (Category ID: 5)
            ProductDTO(name = "Frozen Mixed Berries", price = 6.49, quantity = 5, categoryId = 5, subcategoryId = 15),
            ProductDTO(name = "Frozen Chicken Nuggets", price = 8.99, quantity = 4, categoryId = 5, subcategoryId = 16),
            
            // Pantry Staples (Category ID: 6)
            ProductDTO(name = "White Rice", price = 4.99, quantity = 10, categoryId = 6, subcategoryId = 17),
            ProductDTO(name = "Spaghetti", price = 2.99, quantity = 8, categoryId = 6, subcategoryId = 18),
            ProductDTO(name = "Olive Oil", price = 9.99, quantity = 6, categoryId = 6, subcategoryId = 19),

            // Snacks & Beverages (Category ID: 7)
            ProductDTO(name = "Potato Chips", price = 3.49, quantity = 10, categoryId = 7, subcategoryId = 20),
            ProductDTO(name = "Orange Juice", price = 4.99, quantity = 7, categoryId = 7, subcategoryId = 21),
            ProductDTO(name = "Green Tea", price = 5.99, quantity = 5, categoryId = 7, subcategoryId = 22),

            // Health & Organic Products (Category ID: 8)
            ProductDTO(name = "Organic Spinach", price = 3.99, quantity = 5, categoryId = 8, subcategoryId = 23),
            ProductDTO(name = "Quinoa", price = 6.49, quantity = 4, categoryId = 8, subcategoryId = 24),

            // Household Essentials (Category ID: 9)
            ProductDTO(name = "Dish Soap", price = 3.49, quantity = 6, categoryId = 9, subcategoryId = 25),
            ProductDTO(name = "Paper Towels", price = 7.99, quantity = 5, categoryId = 9, subcategoryId = 26),

            // Baby & Personal Care (Category ID: 10)
            ProductDTO(name = "Baby Wipes", price = 4.99, quantity = 10, categoryId = 10, subcategoryId = 27),
            ProductDTO(name = "Shampoo", price = 6.49, quantity = 8, categoryId = 10, subcategoryId = 28)
)