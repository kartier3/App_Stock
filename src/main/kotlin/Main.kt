import models.Product
import models.Supplier
import Controllers.ProductAPI
import Controllers.SupplierAPI
import Controllers.addSupplier
import Controllers.addProduct



fun main() {

    val supplierAPI = SupplierAPI()
    val productAPI = ProductAPI(supplierAPI)
    var option: Int




    do {
        println()
        println("1. Add Supplier")
        println("2. Add Product")
        println("3. List Suppliers")
        println("4. List Products")
        println("0. Exit")
        print("Select option: ")

        option = readln().toIntOrNull() ?: -1

        when (option) {
            1 -> addSupplier(supplierAPI)
            2 -> addProduct(productAPI)
            3 -> println(supplierAPI.getAllSuppliers())
            4 -> println(productAPI.getAllProducts())
            0 -> println("Exiting...")
            else -> println("Invalid option")
        }


    } while (option != 0)
}

