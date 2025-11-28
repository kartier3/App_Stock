- Kotlin Documentation: https://kotlinlang.org/docs/home.html
- JetBrains IntelliJ IDEA Guide: https://www.jetbrains.com/help/idea/
- JSON Serialization Concepts: https://www.json.org/

# App_Stock
App_Stock – README

## Table of Contents
- [1. Introduction](#1-introduction)
- [2. Functionalities](#2-functionalities)
- [3. Good Things](#3-good-things)
- [4. References](#4-references)




 ## 1. Introduction
   

App_Stock is a stock management system built with Kotlin, 
created for a first-semester programming project. 
The application handles products and suppliers through a structured menu system
and saves data using a JSON-based storage method
Its design maintains a clear separation of functions, including models
,controllers, menus, and storage, which makes the code simple to maintain 
and expand.

## 2. Functionalities

System provides:

- Product Management
- Add new products
- List all products
- Search for a product
- Update existing product details
- Delete a product
- Supplier Management
- Add suppliers
- List suppliers
- Search suppliers
- Update supplier details
- Delete suppliers
- Data Persistence
- Saves and loads data using a custom Serializer
- JSON-based storage implemented in persistance package
- Ensures products and suppliers persist between sessions
- enu System
- Interactive console menus for both Products and Suppliers
- Validated user input
- Clear navigation and feedback messages


## 3. Good Things

Project demonstrates several good qualities:

- Fair Architecture

Uses (Models, Controllers, Menus)

Code is fairly neat

- Reusable & Clean Models

Data classes (product.kt, supplier.kt) are simple, readable, and efficient

- Robust CRUD Operations

Both ProductAPI and SupplierAPI implement full CRUD functionality

Search and validation methods add reliability

- Persistence Layer

Custom serializer framework shows understanding of file handling




## 4. References

- https://github.com/NaturalIntelligence/fast-xml-parser
- https://github.com/matiassingers/awesome-readme/blob/master/readme.md
- https://www.youtube.com/watch?v=EExSSotojVI
- https://github.com/Kotlin/kotlinx.serialization
- https://github.com/Kotlin/dokka
- https://github.com/Kotlin/dokka-plugin-template
