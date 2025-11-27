package models

data class Product(
    val productId: Int,
    var name: String,
    var cost: Double,
    val supplierId: Int
)