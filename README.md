# SpeakShelf Backend API

## 1. Project Overview

SpeakShelf Backend is a Spring Boot REST API for an Accessible Reading List web application. The backend allows authenticated users to manage books and articles. Users can create, view, search, update, and delete reading items.

The backend uses MySQL for data storage, Spring Data JPA for database operations, Jakarta Validation for input validation, and Spring Security Basic Authentication to protect the API endpoints.

---

## 2. Technologies Used

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Jakarta Validation
- MySQL
- Maven
- Git and GitHub
- Postman / Browser for API testing

---

## 3. Project Structure

```text
src/main/java/com/arl/arl_backend
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   └── BookController.java
│
├── entity
│   └── Book.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── repository
│   └── BookRepository.java
│
├── service
│   └── BookService.java
│
└── ArlBackendApplication.java
```

### Layer Explanation

| Layer | Purpose |
|---|---|
| Entity | Defines the `Book` model and validation rules |
| Repository | Handles database operations using Spring Data JPA |
| Service | Contains business logic for CRUD, search, and pagination |
| Controller | Provides REST API endpoints under `/api/books` |
| Config | Handles Basic Authentication and CORS configuration |
| Exception | Handles validation errors and custom error responses |

---

## 4. Database Setup

Create the MySQL database:

```sql
CREATE DATABASE IF NOT EXISTS arl_db;

USE arl_db;

CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL
);
```

Database name:

```text
arl_db
```

Main table:

```text
books
```

---

## 5. Backend Configuration

Open:

```text
src/main/resources/application.properties
```

Example configuration:

```properties
spring.application.name=arl-backend

spring.datasource.url=jdbc:mysql://localhost:3306/arl_db
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace:

```text
your_mysql_password
```

with your actual MySQL password.

---

## 6. How to Run Backend

### Option 1: Run using IntelliJ IDEA

1. Open the backend project in IntelliJ IDEA.
2. Make sure MySQL is running.
3. Open the main class:

```text
ArlBackendApplication.java
```

4. Click the Run button.

The backend will run at:

```text
http://localhost:8080
```

### Option 2: Run using Maven

In the backend project folder, run:

```bash
mvn spring-boot:run
```

---

## 7. Authentication

The backend uses Spring Security Basic Authentication.

Default credentials:

```text
Username: user
Password: password123
```

All API requests require Basic Auth.

---

## 8. API Endpoints

Base URL:

```text
http://localhost:8080/api/books
```

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/books?page=0&size=5` | Get all books with pagination |
| GET | `/api/books?q=keyword&page=0&size=5` | Search books |
| GET | `/api/books/{id}` | Get book by ID |
| POST | `/api/books` | Create a new book |
| PUT | `/api/books/{id}` | Update an existing book |
| DELETE | `/api/books/{id}` | Delete a book |

---

## 9. Sample API Requests

### 9.1 Get All Books

Method:

```text
GET
```

URL:

```text
http://localhost:8080/api/books?page=0&size=5
```

Expected status:

```text
200 OK
```

---

### 9.2 Search Books

Method:

```text
GET
```

URL:

```text
http://localhost:8080/api/books?q=java&page=0&size=5
```

Expected status:

```text
200 OK
```

---

### 9.3 Get Book by ID

Method:

```text
GET
```

URL:

```text
http://localhost:8080/api/books/1
```

Expected status if found:

```text
200 OK
```

Expected status if not found:

```text
404 Not Found
```

---

### 9.4 Add New Book

Method:

```text
POST
```

URL:

```text
http://localhost:8080/api/books
```

Headers:

```text
Content-Type: application/json
Authorization: Basic Auth
```

Request body:

```json
{
  "title": "Java Programming",
  "author": "Cassie",
  "category": "Education",
  "description": "A beginner-friendly guide to Java programming."
}
```

Expected status:

```text
201 Created
```

---

### 9.5 Update Book

Method:

```text
PUT
```

URL:

```text
http://localhost:8080/api/books/1
```

Headers:

```text
Content-Type: application/json
Authorization: Basic Auth
```

Request body:

```json
{
  "title": "Advanced Java Programming",
  "author": "Cassie",
  "category": "Education",
  "description": "An updated Java programming reference."
}
```

Expected status:

```text
200 OK
```

---

### 9.6 Delete Book

Method:

```text
DELETE
```

URL:

```text
http://localhost:8080/api/books/1
```

Expected status:

```text
204 No Content
```

---

## 10. Validation Rules

| Field | Rule |
|---|---|
| title | Required, maximum 150 characters |
| author | Required, maximum 100 characters |
| category | Required, maximum 50 characters |
| description | Required, maximum 500 characters |

Example invalid request body:

```json
{
  "title": "",
  "author": "",
  "category": "",
  "description": ""
}
```

Expected status:

```text
400 Bad Request
```

Example validation response:

```json
{
  "status": 400,
  "error": "Bad Request",
  "messages": {
    "title": "Title is required",
    "author": "Author is required",
    "category": "Category is required",
    "description": "Description is required"
  }
}
```

---

## 11. Error Handling

### Book Not Found

```json
{
  "status": 404,
  "error": "Not Found",
  "message": "Book not found with id: 1"
}
```

### Missing Request Body

```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Request body is required."
}
```

---

## 12. HTTP Status Codes

| Status Code | Meaning |
|---|---|
| 200 OK | Request successful |
| 201 Created | New book created |
| 204 No Content | Book deleted successfully |
| 400 Bad Request | Invalid request or validation error |
| 401 Unauthorized | Authentication is required |
| 404 Not Found | Book not found |

---

## 13. GitHub Repository

```text
https://github.com/yixuennn/arl-backend
```

---

## 14. Git Commit Practice

Example backend commit messages:

```text
Create book CRUD API using controller service and repository layers
Add validation and global error handling
Configure basic authentication and CORS
Update backend README with setup and API requests
```

---

## 15. Conclusion

The SpeakShelf backend fulfills the assignment requirements by providing secured CRUD REST APIs under `/api/books`. It includes MySQL database integration, Spring Data JPA, validation, search, pagination, Basic Authentication, CORS configuration, and meaningful error handling.
