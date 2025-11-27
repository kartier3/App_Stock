package Controllers

import models.Product
import java.io.File

class ProductAPI(private val supplierAPI: SupplierAPI) {

    private val products = ArrayList<Product>()


    fun addProduct(product: Product): Boolean {return products.add(product)}
    fun addProductuser(api: ProductAPI) {
        print("Product ID: ")
        var id = readln().toInt()

        while (productIdExists(id)) {
            println("ID already exists. Enter a different ID:")
            id = readln().toInt()
        }

        print("Name: ")
        val name = readln()
        print("Cost: ")
        val cost = readln().toDouble()
        print("Supplier ID: ")
        var supplierId = readln().toInt()
        val newProduct = Product(id, name, cost, supplierId)
        val added = addProduct(newProduct)

        if (added) {
            println("Product added successfully!")
        } else {
            println("Failed to add product.")
        }
    }

    fun productIdExists(id: Int): Boolean {
        for (p in products) {
            if (p.productId == id) return true
        }
        return false
    }

    fun getAllProducts(): List<Product> {return products }

    fun displayProducts(list: List<Product>) {
        if (list.isEmpty()) {
            println("No products found.")
        } else {
            println("Products:")
            val sortedList = list.sortedBy { it.productId }
            for (product in list) {
                println("${product.productId} ${product.name} (€${product.cost}) — Supplier ID: ${product.supplierId}")
            }
        }
    }



    val cheapProduct: () -> List<Product> = {
        val result = mutableListOf<Product>()
        for (product in products) {
            if (product.cost < 3.0) {
                result.add(product)
            }
        }
        result
    }
    fun displayCheapProducts(list: List<Product>) {
        if (list.isEmpty()) {
            println("No cheap products (below €3.0).")
        } else {
            println("Cheap products (cost < €3):")
            for (p in list) {
                println("${p.productId}. ${p.name} (€${p.cost}) — Supplier ID: ${p.supplierId}")
            }
        }
    }

    val productsBySupplier: (Int) -> List<Product> = { supplierId ->
        val result = mutableListOf<Product>()
        for (p in products) {
            if (p.supplierId == supplierId) {
                result.add(p)
            }
        }
        result
    }
    fun deleteProduct(id: Int): Boolean {
        getAllProducts()
        for (product in products) {
            if (product.productId == id) {
                products.remove(product)
                return true
            }
        }
        return false
    }
}

