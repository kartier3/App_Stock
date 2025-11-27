package Controllers
import models.Supplier



class SupplierAPI {

    private val suppliers = mutableListOf<Supplier>()

    fun addSupplier(supplier: Supplier): Boolean { return suppliers.add(supplier) }
    fun getAllSuppliers(): List<Supplier> {return suppliers}
}

fun addSupplier(api: SupplierAPI) {
    print("Supplier ID: ")
    val id = readln().toInt()

    print("Name: ")
    val name = readln()

    print("Contact: ")
    val contact = readln()

}