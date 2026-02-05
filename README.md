# Item Service - Spring Boot REST API

## Description
Simple Java Spring Boot application providing REST APIs to manage items using in-memory storage.

## Technologies
- Java 17
- Spring Boot
- REST API
- ArrayList (In-memory)

## How to Run
1. Clone the repository
2. Run the application using:
   mvn spring-boot:run
3. Application runs on port 8080

## API Endpoints

### Add Item
POST /items

Request Body:
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 70000,
  "quantity": 3
}

### Get Item by ID
GET /items/{id}

Response Body:
{
	"id":1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 70000,
  "quantity": 3
}

## Notes
- No database used
- Data stored in memory
- Validation enabled

### Additional Features

## Exception Handling

- Global exception handling implemented using 'RestControllerAdvice'
- Custom business exception for item not found
- Validation errors handled with meaningful messages
- Generic internal exceptions handled safely without exposing internal details

### Sample Error Response

json
{
  "status": 400,
  "message": "name: Name is required",
  "timestamp": "2026-02-05T16:30:45"
}