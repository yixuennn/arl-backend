## 1. Authentication
This API uses Basic Authentication

```text
Username: user
Password: password123
```

---

## 2. Base URL
```bash
http://localhost:8080/api/books
```

---

## 3. Create Book
```bash
POST /api/books
```

```json
{
  "title": "Sample Book",
  "author": "Kerxin",
  "category": "Test",
  "description": "Testing API"
}
```

---

## 4. Get Books
```bash
GET /api/books
```

---

## 5. Pagination
```bash
GET /api/books?page=0&size=5
```

---

## 6. Search
```bash
GET /api/books/search?q=java
```

---

## 7. Update Book
```bash
PUT /api/books/{id}
```

```json
{
  "title": "Updated Book",
  "author": "Kerxin",
  "category": "Updated",
  "description": "Updated description"
}
```

---

## 8. Delete Book
```bash
DELETE /api/books/{id}
```

---

## 9. Testing Tool
```text
Postman
```

---