package Controllers
import models.Supplier
import persistence.Serializer



class SupplierAPI(
    private val serializer: Serializer
) {
    private var suppliers = ArrayList<Supplier>()


    @Throws(Exception::class)
    fun store() {
        serializer.write(suppliers)
    }

    @Throws(Exception::class)
    fun load() {
        suppliers = serializer.read() as ArrayList<Supplier>
    }

    /**
     * @param supplier the supplier to add
     * @return true if added successfully
     */
    fun addSupplier(supplier: Supplier): Boolean { return suppliers.add(supplier) }
    /**
     * @param api SupplierAPI instance for validation
     */
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

    /**
     * @return list of all suppliers
     */
    fun getAllSuppliers(): List<Supplier> {return suppliers}
    /**
     * @param list suppliers to display
     */
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
    /**
     * @param id supplier ID to check
     * @return true if ID exists
     */
    fun supplierIdExists(id: Int): Boolean {
        for (s in suppliers) {
            if (s.supplierId == id) return true
        }
        return false
    }
    /**
     * @param id supplier ID to delete
     * @return true if deleted successfully
     * @author Oleh Radzykhovskyi
     */
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



