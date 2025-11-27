package models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.*

class SupplierTest {

    private var Supplier = ArrayList<Supplier>()

    @Test
    fun getSupplierId() {
        val y = Supplier(1, "John", "12345")
        assertEquals(1, y.supplierId)
    }

    @BeforeEach
    fun setup() {
        Supplier.clear()
        Supplier.add(Supplier(1, "John", "12345"))
    }

    @AfterEach
    fun tearDown() {
        Supplier.clear()
    }

    @Test
    fun getName() {
        val y = Supplier(1, "John", "12345")
        assertEquals("John", y.name)
    }

    @Test
    fun setName() {
        val y = Supplier(1, "John", "12345")
        y.name = "Mary"
        assertEquals("Mary", y.name)
    }

    @Test
    fun getContact() {
        val y = Supplier(1, "John", "12345")
        assertEquals("12345", y.contact)
    }

    @Test
    fun setContact() {
        val y = Supplier(1, "John", "12345")
        y.contact = "99999"
        assertEquals("99999", y.contact)
    }

    @Test
    fun component1() {
        val y = Supplier(1, "John", "12345")
        assertEquals(1, y.component1())
    }

}