package Controllers
import models.Supplier



class SupplierAPI {

    private val suppliers = ArrayList<Supplier>()

    fun addSupplier(supplier: Supplier): Boolean { return suppliers.add(supplier) }



    fun getAllSuppliers(): List<Supplier> {return suppliers}
    fun displaySuppliers(list: List<Supplier>) {
        if (list.isEmpty()) {
            println("No suppliers found.")
        } else {
            println("Suppliers:")
            for (supplier in list) {
                println("${supplier.supplierId}. ${supplier.name} - ${supplier.contact}")
            }
        }
    }


    fun addSupplieruser(api: SupplierAPI) {
        print("Supplier ID: ")
        val id = readln().toInt()

        print("Name: ")
        val name = readln()

        print("Contact: ")
        val contact = readln()

    }

    fun deleteSupplier(id: Int): Boolean {
        getAllSuppliers()
        for (supplier in suppliers) {
            if (supplier.supplierId == id) {
                suppliers.remove(supplier)
                return true
            }
        }
        return false
    }


}



