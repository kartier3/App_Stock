package Controllers
import models.Supplier



class SupplierAPI {

    private val suppliers = mutableListOf<Supplier>()

    fun addSupplier(supplier: Supplier): Boolean {return suppliers.add(supplier)}
    fun getAllSuppliers(): List<Supplier> {return suppliers}
}