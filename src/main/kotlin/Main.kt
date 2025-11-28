import models.Product
import models.Supplier
import Controllers.ProductAPI
import Controllers.SupplierAPI
import Menus.productMenu
import Menus.supplierMenu





fun main() {

    val supplierAPI = SupplierAPI()
    val productAPI = ProductAPI(supplierAPI)
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
        println("│ 0 → Exit                 │")
        println("└──────────────────────────┘")
        print("Select option: ")
        option = readln().toIntOrNull() ?: -1

        when(option) {
            1 -> supplierMenu(supplierAPI, productAPI)
            2 -> productMenu(productAPI)
            0 -> println("Exiting...")
            else -> println("Invalid option")
        }

    } while(option != 0)
}
