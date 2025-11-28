package Menus

import models.Product
import Controllers.ProductAPI




fun productMenu(productAPI: ProductAPI) {
    var option: Int

    do {
        println()
        println("┌──────────────────────────┐")
        println("│       PRODUCT MENU       │")
        println("├──────────────────────────┤")
        println("│ 1 → Add Product          │")
        println("│ 2 → List Products        │")
        println("│ 3 → Cheap Products       │")
        println("│ 4 → Products by Supplier │")
        println("│ 5 → Delete Product       │")
        println("│ 0 → Back                 │")
        println("└──────────────────────────┘")

        option = readln().toIntOrNull() ?: -1

        when (option) {

            1 -> productAPI.addProductuser(productAPI)

            2 -> productAPI.displayProducts(productAPI.getAllProducts())

            3 -> productAPI.displayCheapProducts(productAPI.cheapProduct())

            4 -> {
                print("Enter Supplier ID: ")
                val id = readln().toInt()
                displayProductsWithTitle("Products from supplier $id:", productAPI.productsBySupplier(id))
            }

            5 -> {
                println("Enter product ID to delete among those: ")
                productAPI.displayProducts(productAPI.getAllProducts())
                val id = readln().toInt()
                println(productAPI.deleteProduct(id))
            }

            0 -> println("Returning to main menu...")
            else -> println("Invalid option")
        }

    }while (option != 0)








    fun displayProductsWithTitle(title: String, list: List<Product>) {
        if (list.isEmpty()) {
            println("No products found.")
        } else {
            println(title)
            for (p in list) {
                println("${p.productId}. ${p.name} (€${p.cost}) — Supplier ID: ${p.supplierId}")
            }
        }
    }}

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
