package Controllers

import models.Product
import java.io.File
import persistence.XMLSerializer
import persistence.Serializer




/**
 * Manages all product-related operations in the Stock application.
 *
 * @constructor Just a constractor
 * @property supplierAPI reference to the SupplierAPI for supplier validation
 */
class ProductAPI(
    private val supplierAPI: SupplierAPI,
    private val serializer: Serializer
) {
    private var products = ArrayList<Product>()


    @Throws(Exception::class)
    fun store() {
        serializer.write(products)
    }

    @Throws(Exception::class)
    fun load() {
        products = serializer.read() as ArrayList<Product>
    }

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
            val productName = readln()
        print("Cost: ")
            val costInput = readln()
            val cost = costInput.toDoubleOrNull() ?: -1.0

        print("Supplier ID: ")
            val supplier = readln()
            var supplierId = supplier.toInt()

            val prod = Product(id, productName, cost, supplierId)

            val wasAdded = addProduct(prod)

        if (wasAdded == true) {
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
        for (y in products) {
            if (y.productId == id) return true
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
    fun displayProducts(list: ArrayList<Product>) {
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
            val cheap = ArrayList<Product>()

        for (y in products) {
            if (y.cost < 3.0) {
                cheap.add(y)
            }
        }

        cheap
    }


    /**
     * @param list the list of cheap products to display
     */
    fun displayCheapProducts(items: List<Product>) {
        if (items.size == 0) {
            println("No cheap products (below €3.0).")
        } else {
            println("Cheap products (cost < €3):")
            for (item in items) {
                println("${item.productId}. ${item.name} (€${item.cost}) — Supplier ID: ${item.supplierId}")
            }
        }
    }


    /**
     *
     * @param supplierId the supplier's ID
     * @return list of products associated with that supplier
     */
    val productsBySupplier: (Int) -> List<Product> = { supplierId ->

            val matchingProducts = mutableListOf<Product>()

        for (product in products) {
            if (product.supplierId == supplierId) {
                matchingProducts.add(product)
            }
        }
        matchingProducts
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

