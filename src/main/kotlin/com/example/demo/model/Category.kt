pacakge com.example.demo.model

import jakarta.persistence.*
import com.example.demo.model.Product

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = ""

    @OnetoMany(mappedBy = "category", cascade = [CascadeType.ALL])
    @JsonIgnoreProperties("category")
    val products: MutableList<Product> = mutableListOf()
) {
    // Explicit no-argument constructor for Hibernate
    constructor() : this(0, "")
}