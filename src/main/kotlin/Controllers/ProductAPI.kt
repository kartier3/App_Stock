package Controllers

import models.Product
import java.io.File

class ProductAPI(private val supplierAPI: SupplierAPI) {

    private val products = ArrayList<Product>()


    fun addProduct(product: Product): Boolean {return products.add(product)}

    fun getAllProducts(): List<Product> {return products }
    fun displayProducts(list: List<Product>) {
        if (list.isEmpty()) {
            println("No products found.")
        } else {
            println("Products:")
            for (p in list) {
                println("${p.productId} ${p.name} (€${p.cost}) — Supplier ID: ${p.supplierId}")
            }
        }
    }

    fun addProductuser(api: ProductAPI) {
        print("Product ID: ")
        val id = readln().toInt()

        print("Name: ")
        val name = readln()

        print("Cost: ")
        val cost = readln().toDouble()

        print("Supplier ID: ")
        val supplierId = readln().toInt()
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

