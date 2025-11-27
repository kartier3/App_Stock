package Controllers
import models.Supplier



class SupplierAPI {

    private val suppliers = ArrayList<Supplier>()

    fun addSupplier(supplier: Supplier): Boolean { return suppliers.add(supplier) }

    fun addSupplieruser(api: SupplierAPI) {
        print("Supplier ID: ")
        var id = readln().toInt()

        while (api.supplierIdExists(id)) {
            println("ID already exists. Enter a different ID:")
            id = readln().toInt()
        }

        print("Name: ")
        val name = readln()

        print("Contact: ")
        val contact = readln()

        val newSupplier = Supplier(id, name, contact)
        val added = api.addSupplier(newSupplier)

        if (added) {
            println("Supplier added successfully!")
        } else {
            println("Failed to add supplier.")
        }
    }


    fun getAllSuppliers(): List<Supplier> {return suppliers}

    fun displaySuppliers(list: List<Supplier>) {
        if (list.isEmpty()) {
            println("No suppliers found.")
        } else {
            println("Suppliers:")
            val sortedList = list.sortedBy { it.supplierId }
            for (supplier in sortedList) {
                println("${supplier.supplierId}. ${supplier.name} - ${supplier.contact}")
            }
        }
    }

    fun supplierIdExists(id: Int): Boolean {
        for (s in suppliers) {
            if (s.supplierId == id) return true
        }
        return false
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



