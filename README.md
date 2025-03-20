# ProgrammingTechCoursework
University coursework for Programming Technologies.

## Requirements

Create a shop with different types of users connecting to it. Customers can register themselves, employees are registered by administrators. You can view products, buy them, cancel an order, assign responsible managers, confirm an order, manage products, users, etc. You can leave comments on products and orders, comments on products are of unlimited depth, you can leave a rating. Goods are stored in warehouses/stores, there may be several of them. The main requirements for the implementation of the system are:

    * The system has users who connect with their credentials and access only the data intended for them (For example, customers cannot see system users, but they can see their orders and goods. Managers can see all users, but cannot change them, only their data; employees of different levels and can see and perform different functions, etc.); [1]
    * There are at least 2 types of users - customers and store employees/managers (name, surname, contact information, date of birth, etc. must be saved). Both customers and managers have characteristics common to both, but also differ in some ways. When connecting with a login and password, the password must be hashed in the database; [0.5]
    * Customers choose goods from the list of available products, leave ratings and comments about the products, can chat with manager on specific order. They can also view purchase history, cancel pending orders, pay for the order, etc. [1]
    * All editing rights belong to administrators (how you implement it, is your choice); [1]
    * Store managers fully manage orders (they cannot delete already completed or ongoing orders), fully manage products and information about stores. Managers assign the managers responsible for the order, it can be changed later. All unassigned orders are visible to all managers and they can "assign" the order. If the order is not assigned up within one working day, it should be marked as urgent to be seen as soon as possible. [1]
    * Both customers and managers can write and reply to other comments on products. The order comes with a simple messaging option [1]
    * The depth of comments on products is unlimited. [2]
    * You can filter orders by creation dates (within some range), statuses, customers, etc. Choose at least 3 attributes to filter by [2]
    * Statistics are provided (text + graph). For example, how much was sold during some interval, what amount, how many different orders, etc. Connect with task 8. [2] [OPTIONAL]
    * The system must consist of two subsystems: a desktop system and an online system (web server). [0.5]


## Contributing

No need. The work is finalized and just here for storage and review.
