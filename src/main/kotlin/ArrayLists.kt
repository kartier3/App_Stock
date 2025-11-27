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






}
