# Employee Management System

This project is an Employee Management System built with Spring Boot (backend), Thymeleaf (frontend), and PostgreSQL (database). The application allows the management of employees, including adding, updating, deleting, and listing employees. It calculates the salary based on employee types such as permanent, contractual, and commission-based.

## Features

- **Add Employee**: Allows the user to add new employees with information like matricule, name, type, and salary.
- **Edit Employee**: Users can update employee details such as name, type, and salary.
- **Delete Employee**: Users can delete employees from the system.
- **Employee List**: Displays a list of employees with their matricule, name, type, and salary.

## Technologies Used

- **Backend**: Spring Boot
- **Frontend**: Thymeleaf
- **Database**: PostgreSQL
- **Build Tool**: Gradle
- **Java Version**: Java 11 or higher

## Installation

### Clone the Repository

```bash
git clone https://github.com/Bencabdessamad/ManagmentEmployee.git
cd ManagmentEmployee
Set Up the Database
Install PostgreSQL and create a database named employee_management.
Configure your application.properties in the src/main/resources folder with the following:
properties
Copier le code
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_management
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build and Run the Application
Install dependencies and build the project using Gradle:
bash
Copier le code
./gradlew build
Run the Spring Boot application:
bash
Copier le code
./gradlew bootRun
Access the application on http://localhost:8080/employees.
Endpoints
GET /employees: List all employees.
POST /employees/add: Add a new employee.
GET /employees/edit/{matricule}: Edit an employee's details.
POST /employees/edit: Update employee details.
GET /employees/delete/{matricule}: Delete an employee.
