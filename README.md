# 🚀 Employee Task Management System - Backend

A RESTful backend application built using **Spring Boot** that enables organizations to efficiently manage employees and their assigned tasks. The application provides complete CRUD operations for Employees and Tasks, following a clean layered architecture and storing data in a PostgreSQL database.

---

# 📖 Project Overview

The **Employee Task Management System (ETMS)** backend is designed to simplify employee and task management within an organization.

It exposes REST APIs that allow clients to perform Create, Read, Update, and Delete (CRUD) operations on Employees and Tasks. The project follows Spring Boot best practices with a clean architecture consisting of Controller, Service, Repository, and Entity layers.

---

# ✨ Features

## 👨‍💼 Employee Management

* Add Employee
* View All Employees
* View Employee By ID
* Update Employee Details
* Delete Employee

## ✅ Task Management

* Add Task
* View All Tasks
* View Task By ID
* Update Task Details
* Delete Task

---

# 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate ORM
* PostgreSQL
* Maven
* RESTful Web Services
* Postman (API Testing)
* Spring Tool Suite (STS)

---

# 🏗️ Architecture

The project follows a layered architecture:

```text
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
PostgreSQL Database
```

---

# 📂 Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controller
│   │   ├── entity
│   │   ├── repository
│   │   ├── service
│   │   ├── exception
│   │   └── EmployeeTaskManagementApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── pom.xml
```

---

# 🗄️ Database

* Database : PostgreSQL
* ORM : Hibernate (Spring Data JPA)

---

# ⚙️ Configuration

Before running the application, update the `application.properties` file with your PostgreSQL database configuration.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<your_database_name>
spring.datasource.username=<your_username>
spring.datasource.password=<your_password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082
```

Replace the placeholder values with your PostgreSQL database name, username, and password.

> **Note:** Never commit your actual database credentials to a public GitHub repository.

---

# ▶️ Getting Started

## 1. Clone the Repository

```bash
git clone https://github.com/shibanandarout/employee-task-management.git
```

## 2. Open the Project

Import the project into:

* Spring Tool Suite (STS)
* Eclipse IDE

## 3. Install Dependencies

```bash
mvn clean install
```

## 4. Run the Application

Run the Spring Boot application by executing:

```text
EmployeeTaskManagementApplication.java
```

Or use Maven:

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8082
```

---

# 📡 REST API Endpoints

## Employee APIs

| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| POST   | `/api/employees`      | Create Employee    |
| GET    | `/api/employees`      | Get All Employees  |
| GET    | `/api/employees/{id}` | Get Employee By ID |
| PUT    | `/api/employees/{id}` | Update Employee    |
| DELETE | `/api/employees/{id}` | Delete Employee    |

---

## Task APIs

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/tasks`      | Create Task    |
| GET    | `/api/tasks`      | Get All Tasks  |
| GET    | `/api/tasks/{id}` | Get Task By ID |
| PUT    | `/api/tasks/{id}` | Update Task    |
| DELETE | `/api/tasks/{id}` | Delete Task    |

---

# 🧪 Testing

All REST APIs were tested successfully using **Postman**.

---

# 📌 Project Highlights

* RESTful API Development
* CRUD Operations
* Layered Architecture
* Spring Boot Best Practices
* Spring Data JPA
* Hibernate ORM
* PostgreSQL Integration
* Exception Handling
* Maven Build Management
* Clean and Maintainable Code Structure

---

# 🔮 Future Enhancements

The following features are planned for future versions of the project:

* Spring Security with JWT Authentication
* Role-Based Authorization
* Swagger/OpenAPI Documentation
* Pagination and Sorting
* Search and Filtering
* Docker Containerization
* Unit and Integration Testing
* Email Notifications

---

# 👨‍💻 Author

**Shibananda Rout**

Java Full Stack Developer

GitHub: https://github.com/shibanandarout

---

# ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.
