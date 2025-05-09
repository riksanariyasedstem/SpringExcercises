# Book Inventory Auditing System

## ✅ Setup Instructions

1. Clone the repository
2. Run using your IDE or with `./mvnw spring-boot:run`
3. Access Swagger UI or Postman for API testing

## 🔐 In-Memory Users
- **admin / password / ROLE_ADMIN**
- **user / password / ROLE_USER**

## 🔁 API Endpoints

### POST `/api/v1/books`
Creates a new book

**Request:**
```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch",
  "isbn": "9780134685991",
  "price": 45.99
}
