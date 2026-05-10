🔐 Authentication

This API uses Basic Authentication.

Username: user
Password: password123

📡 Base URL
http://localhost:8080/api/books

➕ Create Book
POST /api/books
{
"title": "Sample Book",
"author": "Kerxin",
"category": "Test",
"description": "Testing API"
}

📖 Get Books
GET /api/books

📄 Pagination
GET /api/books?page=0&size=5

🔍 Search
GET /api/books/search?q=java

✏️ Update Book
PUT /api/books/{id}

❌ Delete Book
DELETE /api/books/{id}

🧪 Testing Tool
Tested using Postman.

👤 Author
Documentation prepared by Kerxin.