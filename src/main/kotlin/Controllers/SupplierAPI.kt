package Controllers
import models.Supplier



class SupplierAPI {

    private val suppliers = ArrayList<Supplier>()


    fun addSupplier(supplier: Supplier): Boolean { return suppliers.add(supplier) }

    fun addSupplieruser(api: SupplierAPI) {
        print("Supplier ID: ")
        val id = readln().toInt()

        print("Name: ")
        val name = readln()

        print("Contact: ")
        val contact = readln()

        val newSupplier = Supplier(id, name, contact)
        if (addSupplier(newSupplier)) {
            println("Supplier added successfully!")
        } else {
            println("Failed to add supplier.")
        }
    }

    fun getAllSuppliers(): List<Supplier> {return suppliers}


    fun displaySuppliers(list: List<Supplier>) {
        if (list.isEmpty()) {
            println("No suppliers")
        } else {
            println("Suppliers:")
            val sortedList = list.sortedBy { it.supplierId }
            for (supplier in sortedList) {
                println("${supplier.supplierId} ${supplier.name}   ${supplier.contact}")
            }
        }
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



