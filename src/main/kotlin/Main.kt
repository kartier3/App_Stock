import models.Product
import models.Supplier
import Controllers.ProductAPI
import Controllers.SupplierAPI




fun main() {

    val supplierAPI = SupplierAPI()
    val productAPI = ProductAPI(supplierAPI)
    var option: Int

    supplierAPI.addSupplier(Supplier(2, "MeatWorld", "Sarah"))

    productAPI.addProduct(Product(2, "Beef", 5.0, 2))

    println(supplierAPI.getAllSuppliers())
    println(productAPI.getAllProducts())
    do {
        println()
        println("1 Add Supplier")
        println("2 Add Product")
        println("3 List Suppliers")
        println("4 List Products")
        println("5 Cheap Products")
        println("6 Product by supplier")
        println("7 delete a product")
        println("8 delete a supplier")
        println("0 Exit")
        print("Select option: ")

        option = readln().toIntOrNull() ?: -1

        when (option) {
            1->supplierAPI.addSupplieruser(supplierAPI)
            2->productAPI.addProductuser(productAPI)
            3-> supplierAPI.displaySuppliers(supplierAPI.getAllSuppliers())
            4-> productAPI.displayProducts(productAPI.getAllProducts())
            5-> productAPI.displayCheapProducts(productAPI.cheapProduct())
            6->  {
            print("Enter Supplier ID: ")
            val id = readln().toInt()
            displayProductsWithTitle("Products from supplier $id:", productAPI.productsBySupplier(id))
            }
            7 -> {
                println("Enter product ID to delete among those: ")
                productAPI.displayProducts(productAPI.getAllProducts())
                val id = readln().toInt()
                println(productAPI.deleteProduct(id))
            }
            8 -> {
                println("Enter supplier ID to delete among those: ")
                supplierAPI.displaySuppliers(supplierAPI.getAllSuppliers())
                val id = readln().toInt()
                println(supplierAPI.deleteSupplier(id))
                    }

            0 -> println("Exiting...")
            else -> println("Invalid option")
        }
    } while (option != 0)

}







fun displayProductsWithTitle(title: String, list: List<Product>) {
    if (list.isEmpty()) {
        println("No products found.")
    } else {
        println(title)
        for (p in list) {
            println("${p.productId}. ${p.name} (€${p.cost}) — Supplier ID: ${p.supplierId}")
        }
    }
}