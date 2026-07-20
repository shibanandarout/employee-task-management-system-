# 🚀 Employee Task Management System (ETMS) - Secure REST API Backend

A secure RESTful backend application built using **Spring Boot** that enables organizations to efficiently manage employees and their assigned tasks. The application provides complete CRUD operations for Employees and Tasks with **JWT-based Authentication**, **Spring Security**, **BCrypt Password Encryption**, and **PostgreSQL** integration.

---

# 📖 Project Overview

The **Employee Task Management System (ETMS)** is designed to simplify employee and task management within an organization.

The application follows a clean layered architecture consisting of Controller, Service, Repository, and Entity layers. It provides secure REST APIs for employee and task management with JWT Authentication, Role-Based Authorization (ADMIN/EMPLOYEE), BCrypt Password Encryption, and Spring Security.

---

# ✨ Features

## 🔐 Authentication & Security

- User Registration
- User Login
- JWT Token Generation
- JWT Authentication Filter
- Password Encryption using BCrypt
- Spring Security Integration
- Role-Based Authorization (ADMIN / EMPLOYEE)
- Protected REST APIs
- Duplicate Email Validation
- Custom AuthenticationEntryPoint
- Custom AccessDeniedHandler
- CORS Configuration for Angular Integration

---

## 👨‍💼 Employee Management

- Add Employee
- View All Employees
- View Employee By ID
- Update Employee Details
- Delete Employee

---

## ✅ Task Management

- Add Task
- View All Tasks
- View Task By ID
- Update Task Details
- Delete Task

---

# 🛠️ Technologies Used

### Backend

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate ORM

### Database

- PostgreSQL


### Security

- Spring Security
- JWT (JJWT)
- BCrypt Password Encoder
- CORS Configuration


### Tools

- Maven
- Postman
- Spring Tool Suite (STS)
- Git
- GitHub

---

# 🏗️ Architecture

The project follows a layered architecture.

```text
                Client
                   │
                   ▼
             REST Controller
                   │
                   ▼
               Service Layer
                   │
                   ▼
            Repository Layer
                   │
                   ▼
             PostgreSQL Database
```

---

# 🔐 Authentication Flow

## Registration Flow

```text
User Registration
        │
        ▼
Password Encrypted using BCrypt
        │
        ▼
Employee Stored in PostgreSQL
```

## Login & Authorization Flow

```text
User Login
      │
      ▼
Email Verification
      │
      ▼
Password Verification
      │
      ▼
JWT Token Generated
      │
      ▼
JWT Returned to Client
      │
      ▼
Angular sends JWT in Authorization Header
      │
      ▼
JWT Authentication Filter
      │
      ▼
Spring Security
      │
      ▼
Protected REST APIs
```

---

# 📂 Project Structure

```text
src
├── main
│
├── java
│   └── com.shibananda.etms
│       ├── config
│       ├── controller
│       ├── dto
│       ├── entity
│       ├── exception
│       ├── jwt
│       ├── repository
│       ├── service
│       ├── serviceimpl
│       └── EmployeeTaskManagementSystemApplication.java
│
└── resources
    └── application.properties

pom.xml
```

---

# 🗄️ Database

- Database : PostgreSQL
- ORM : Hibernate (Spring Data JPA)

---

# ⚙️ Configuration

Update the `application.properties` file before running the project.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<database_name>
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=8082
```

> **Note:** Never commit your actual database credentials to a public repository.

---

# ▶️ Getting Started

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/shibanandarout/employee-task-management-system.git
```

---

## 2️⃣ Open the Project

Import the project into:

- Spring Tool Suite (STS)
- Eclipse IDE

---

## 3️⃣ Install Dependencies

```bash
mvn clean install
```

---

## 4️⃣ Run the Application

Run

```text
EmployeeTaskManagementSystemApplication.java
```

or

```bash
mvn spring-boot:run
```

Application URL

```text
http://localhost:8082
```

---

# 📡 REST API Endpoints

## 🔐 Authentication APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register User |
| POST | `/api/auth/login` | Login & Generate JWT |

## 👨‍💼 Employee APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/employees` | Create Employee |
| GET | `/api/employees` | Get All Employees |
| GET | `/api/employees/{id}` | Get Employee By ID |
| PUT | `/api/employees/{id}` | Update Employee |
| DELETE | `/api/employees/{id}` | Delete Employee (ADMIN only) |

---

## ✅ Task APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/tasks` | Create Task |
| GET | `/api/tasks` | Get All Tasks |
| GET | `/api/tasks/{id}` | Get Task By ID |
| PUT | `/api/tasks/{id}` | Update Task |
| DELETE | `/api/tasks/{id}` | Delete Task |

---

# 🧪 API Testing

All REST APIs were successfully tested using **Postman**.

---

# 📌 Project Highlights

- RESTful API Development
- Layered Architecture
- Employee CRUD Operations
- Task CRUD Operations
- Spring Data JPA
- Hibernate ORM
- PostgreSQL Integration
- DTO Pattern
- Global Exception Handling
- Spring Security
- JWT Authentication
- JWT Authentication Filter
- Role-Based Authorization (ADMIN / EMPLOYEE)
- Protected REST APIs
- BCrypt Password Encryption
- Secure Password Storage using BCrypt
- Duplicate Email Validation
- Custom AuthenticationEntryPoint
- Custom AccessDeniedHandler
- CORS Configuration
- Maven Build Management
- Clean and Maintainable Code

---

# 🔮 Future Enhancements

The following features are planned for future versions:

- Refresh Token Authentication
- Forgot Password & Reset Password
- Email Verification
- Swagger / OpenAPI Documentation
- Pagination & Sorting
- Search & Filtering
- Docker Containerization
- Unit & Integration Testing
- Dashboard Analytics
- Email Notifications

---

# 👨‍💻 Author

**Shibananda Rout**

Java Full Stack Developer

**GitHub**
https://github.com/shibanandarout

---

# ⭐ Support

If you found this project helpful, consider giving it a ⭐ Star on GitHub.
