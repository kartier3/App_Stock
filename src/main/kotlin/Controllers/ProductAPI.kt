package Controllers
import models.Product

class ProductAPI(private val supplierAPI: SupplierAPI) {

    private val products = mutableListOf<Product>()

    fun addProduct(product: Product): Boolean { return products.add(product)
    }

    fun getAllProducts(): List<Product> {return products }
}
fun addProduct(api: ProductAPI) {
    print("Product ID: ")
    val id = readln().toInt()

    print("Name: ")
    val name = readln()

    print("Cost: ")
    val cost = readln().toDouble()

    print("Supplier ID: ")
    val supplierId = readln().toInt()
}