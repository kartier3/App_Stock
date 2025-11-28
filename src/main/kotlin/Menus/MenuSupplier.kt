package Menus
import Controllers.ProductAPI
import models.Supplier
import Controllers.SupplierAPI


fun supplierMenu(supplierAPI: SupplierAPI, productAPI: ProductAPI) {
    var option: Int

    do {
        println("┌───────────────────────────┐")
        println("│       SUPPLIER MENU       │")
        println("├───────────────────────────┤")
        println("│ 1 → Add Supplier          │")
        println("│ 2 → List Suppliers        │")
        println("│ 3 → Delete Supplier       │")
        println("│ 0 → Back                  │")
        println("└───────────────────────────┘")
        print("Select option: ")
        option = readln().toIntOrNull() ?: -1

        when (option) {

            1 -> supplierAPI.addSupplieruser(supplierAPI)

            2 -> supplierAPI.displaySuppliers(supplierAPI.getAllSuppliers())

            3 -> {
                println("Enter supplier ID to delete among those: ")
                supplierAPI.displaySuppliers(supplierAPI.getAllSuppliers())
                val id = readln().toInt()
                println(supplierAPI.deleteSupplier(id))
            }

            0 -> println("Returning to main menu...")
            else -> println("Invalid option")
        }

    } while (option != 0)
}
