import models.Product
import models.Supplier
import Controllers.ProductAPI
import Controllers.SupplierAPI
import Menus.productMenu
import Menus.supplierMenu
import persistence.XMLSerializer
import java.io.File



val supplierSerializer = XMLSerializer(File("suppliers.xml"))
val productSerializer = XMLSerializer(File("products.xml"))

val supplierAPI = SupplierAPI(supplierSerializer)
val productAPI = ProductAPI(supplierAPI, productSerializer)


fun main() {


    var option: Int

    supplierAPI.addSupplier(Supplier(2, "MeatWorld", "Sarah"))
    productAPI.addProduct(Product(2, "Beef", 5.0, 2))

    do {
        println()
        println("┌──────────────────────────┐")
        println("│        MAIN MENU         │")
        println("├──────────────────────────┤")
        println("│ 1 → Supplier Menu        │")
        println("│ 2 → Product Menu         │")
        println("│ 3 → Save All             │")
        println("│ 4 → Load All             │")
        println("│ 0 → Exit                 │")
        println("└──────────────────────────┘")
        print("Select option: ")
        option = readln().toIntOrNull() ?: -1

        when(option) {
            1->        supplierMenu(supplierAPI, productAPI)
            2->        productMenu(productAPI)
            3->        saveAll()
            4->        loadAll()
            0->        println("Exiting_")
            else -> println("Invalid option")
        }

    } while(option != 0)
}


fun saveAll() {
    try {
        supplierAPI.store()
        productAPI.store()
        println("Data saved successfully.")
    } catch (e: Exception) {
        System.err.println("Error writing to file")
    }
}

fun loadAll() {
    try {
        supplierAPI.load()
        productAPI.load()
        println("Data loaded successfully.")
    } catch (e: Exception) {
        System.err.println("Error reading from file: ")
    }
}
