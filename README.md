# Dealer Management System Using Java Swing and MySQL

## About the Project

This project is a **Dealer Management System** developed using **Java Swing** for the user interface and **MySQL** as the backend database.
It supports adding second-hand, new, and trade-in vehicles, managing vehicle sales, recording payments, tracking outstanding balances, and viewing customer payment histories.

The application is designed using the **Model-View-Controller (MVC)** architecture to clearly separate the user interface, business logic, and data handling layers.
Additionally, the **Command Design Pattern** is implemented to encapsulate business actions (such as save, delete, and update) into reusable command classes, enhancing modularity and maintainability.

## Features

* **Add Vehicles:**

  * Second-hand vehicles
  * New vehicles
  * Trade-in vehicles
* **Vehicle Sales:** Record and manage sales transactions
* **Receive Payments:** Process and record customer payments
* **Remaining Balances:** Monitor outstanding payments
* **Customer Payment History:** View detailed payment records

## Technologies

* Java (Swing for GUI)
* MySQL (Relational Database)
* JDBC (Java Database Connectivity)
* **MVC Architecture**
* **Command Design Pattern**

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ilaydademircii/Dealer-Management-System-Using-Java-Swing-MySQL.git
   ```
2. Import the project into your Java IDE (e.g., Eclipse, IntelliJ IDEA).
3. Set up a MySQL database and run the provided SQL scripts (if available) to create the necessary tables.
4. Configure the database connection settings (URL, username, password) in the project’s configuration file or in the source code.
5. Build and run the application.

## Usage

* Use the graphical interface to:

  * Add vehicles by category (second-hand, new, or trade-in)
  * Record and manage sales transactions
  * Receive customer payments and track balances
  * View individual customer payment histories and monitor overall outstanding payments

## Architecture

This project follows a clean **Model-View-Controller (MVC)** design:

* **Model:** Handles data access and business logic
* **View:** Implements the GUI using Java Swing
* **Controller:** Acts as the intermediary between the view and the model

In addition, the **Command Design Pattern** is used to encapsulate operations (e.g., AddVehicleCommand, DeleteCustomerCommand) as objects.
This improves reusability, flexibility, and makes it easier to implement features like undo/redo or logging.

## Contributing

Contributions are welcome! Please fork the repository, implement your changes, and submit a pull request.
