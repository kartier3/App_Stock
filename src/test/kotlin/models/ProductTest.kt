package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*


class ProductTest {

    private var Product = ArrayList<Product>()

    @BeforeEach
    fun setup() {

        Product.clear()

        Product.add(Product(1, "Orange", 1.5, 10))
        Product.add(Product(2, "Milk", 2.5, 20))
        Product.add(Product(3, "Bread", 1.2, 15))
    }

    @AfterEach
    fun tearDown() {
        Product.clear()
    }
    @Test
    fun getProductId() {
        val y = Product(1, "Orange", 1.5, 10)
        assertEquals(1, y.productId)
    }

    @Test
    fun getName() {
        val y = Product(1, "Orange", 1.5, 10)
        assertEquals(1, y.productId)
    }

    @Test
    fun setName() {
        val y = Product(1, "Orange", 1.5, 10)
        y.name = "Bread"
        assertEquals("Bread", y.name)
    }

    @Test
    fun updateName(){
        @Test
        fun updateProductName() {
            val y = Product(3, "Chicken", 1.2, 7)
            y.name = "Fried Chicken"
            assertEquals("Fried Chicken", y.name)
        }
    }

    @Test
    fun getCost() {
        val y = Product(1, "Orange", 1.5, 10)
        assertEquals(1.5, y.cost)
    }

    @Test
    fun setCost() {
        val y = Product(1, "Orange", 1.5, 10)
        y.cost = 2.0
        assertEquals(2.0, y.cost)
    }

    @Test
    fun getSupplierId() {
        val y = Product(1, "Orange", 1.5, 10)
        assertEquals(10, y.supplierId)
    }

    @Test
    fun component1() {
        val y = Product(1, "Orange", 1.5, 10)
        assertEquals(1, y.component1())
    }

}