package Controllers

import models.Product
import java.io.File
/**
 * Manages all product-related operations in the Stock application.
 *
 * @constructor Just a constractor
 * @property supplierAPI reference to the SupplierAPI for supplier validation
 */
class ProductAPI(private val supplierAPI: SupplierAPI) {

    private val products = ArrayList<Product>()

    /**
     * Adds a new product to the product list.
     *
     * @param product the product to add
     * @return true if the product was added successfully
     */
    fun addProduct(product: Product): Boolean {return products.add(product)}

    /**
     * Adds a new product using user input.

     * @param api
     */
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
    /**
     * Checks whether a product with a given ID already exists, just to exclude repetetives
     *
     * @param id the product ID to check
     * @return true or false, ddepends on an existance
     */
    fun productIdExists(id: Int): Boolean {
        for (p in products) {
            if (p.productId == id) return true
        }
        return false
    }

    /**
     * @return a list of all product objects
     */
    fun getAllProducts(): List<Product> {return products }
    /**
     * @param list the list of products to display
     */
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


    /**
     * Lambda that returns all products costing less than €3.0.
     * @return a list of cheap products
     */
    val cheapProduct: () -> List<Product> = {
        val result = mutableListOf<Product>()
        for (product in products) {
            if (product.cost < 3.0) {
                result.add(product)
            }
        }
        result
    }

    /**
     * @param list the list of cheap products to display
     */
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

    /**
     *
     * @param supplierId the supplier's ID
     * @return list of products associated with that supplier
     */
    val productsBySupplier: (Int) -> List<Product> = { supplierId ->
        val result = mutableListOf<Product>()
        for (p in products) {
            if (p.supplierId == supplierId) {
                result.add(p)
            }
        }
        result
    }

    /**
     * Deletes a product with the given ID.
     *
     * @param id the product ID to delete
     * @return true if a product was deleted, otherwise false
     * @author Oleh Radzykhovskyi
     */
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

