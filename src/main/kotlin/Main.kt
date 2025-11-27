import models.Product
import models.Supplier
import Controllers.ProductAPI
import Controllers.SupplierAPI



fun main() {

    val supplierAPI = SupplierAPI()
    val productAPI = ProductAPI(supplierAPI)

    supplierAPI.addSupplier(Supplier(1, "FreshFoods", "John"))
    supplierAPI.addSupplier(Supplier(2, "MeatWorld", "Sarah"))

    productAPI.addProduct(Product(1, "Milk", 1.2, 1))
    productAPI.addProduct(Product(2, "Beef", 5.0, 2))

    println(supplierAPI.getAllSuppliers())
    println(productAPI.getAllProducts())
}