A simple RESTful payment service built with Spring Boot and PostgreSQL. 
This project provides an API for creating, managing, and tracking payments, with support for multiple currencies and client-specific payment history.

# Features
- [x] Create payments with a default PENDING status
- [x] Retrieve payment status by ID
- [x] Confirm or cancel payments with state validation
- [x] Get a list of all payments for a specific client
- [x] Input validation (positive amounts, supported currencies: KZT, USD, EUR, RUB, CNY)
- [x] Error handling with appropriate HTTP status codes (400, 404)

# Setup

1. Clone the Repository\
**git clone https://github.com/MadiZhaksykeldi/payment-app.git 
cd payment-app**

2. Configure PostgreSQL\
• Create a database named payment_db:
**CREATE DATABASE payment_db;**

• Update the database connection details in src/main/resources/application.properties:\
spring.datasource.url=jdbc:postgresql://localhost:your_port/payment_db\
spring.datasource.username=your_username\
spring.datasource.password=your_password\
spring.datasource.driver-class-name=org.postgresql.Driver

3. Build and Run
• Build the project with Maven:\
**mvn clean install**

• Run the application:\
**mvn spring-boot:run**

The API will be available at **http://localhost:8080/api**.

# API Endpoints

1. Create Payment\
• Method: POST\
• URL: /api/payments\
• Body:\
**{\
  "amount": 1000,\
  "currency": "KZT",\
  "description": "Order #123 payment",\
  "clientId": "12345"\
}**\
• Response: (201 Created)\
**{\
  "paymentId": 1,\
  "status": "PENDING"\
}**

2. Get Payment Status\
• Method: GET\
• URL: /api/payments/{paymentId}\
• Example: /api/payments/1\
• Response: (200 OK)\
**{\
  "paymentId": 1,\
  "amount": 1000,\
  "currency": "KZT",\
  "description": "Order #123 payment",\
  "clientId": "12345",\
  "status": "PENDING"\
}**

3. Confirm Payment\
• Method: $${\color{yellow}POST}$$\
• URL: /api/payments/{paymentId}/confirm\
• Example: /api/payments/1/confirm\
• Response: (200 OK)\
**{\
  "paymentId": 1,\
  "status": "CONFIRMED"\
}**

4. Cancel Payment\
• Method: POST\
• URL: /api/payments/{paymentId}/cancel\
• Example: /api/payments/1/cancel\
• Response: (200 OK)\
**{\
  "paymentId": 1,\
  "status": "CANCELED"\
}**

5. Get Client Payments\
• Method: GET\
• URL: /api/clients/{clientId}/payments\
• Example: /api/clients/12345/payments\
• Response: (200 OK)\
**{\
  "paymentId": 1,\
  "amount": 1000,\
  "currency": "KZT",\
  "status": "CONFIRMED"\
}**\

6. Error Responses\
• 404 Not Found: Payment or client not found\
  **"Payment not found"**\
• 400 Bad Request: Invalid operation (e.g., confirming an already confirmed payment)\
  **"Payment cannot be confirmed"**










