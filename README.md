# Hotel CRUD REST API

A simple CRUD REST API for managing hotel information built with **Java Spring Boot** and **Maven**.

## Features

- **Create**: Add new hotel information.
- **Read**: Retrieve hotel details.
- **Update**: Modify existing hotel data.
- **Delete**: Remove hotel records.

## Tech Stack

- **Java 17+**
- **Spring Boot** (REST API, JPA, Hibernate)
- **Maven** (Build Tool)
- **H2 Database** (In-memory database for development)
- **Swagger** (API Documentation)

---

## Getting Started

### Prerequisites

Ensure you have the following installed on your system:
- **Java 17+**
- **Maven 3.8+**

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-springboot-hotel-api.git
   cd java-springboot-hotel-api
   ```
2. Build the project:
    ```bash
    mvn clean install
    Run the application:
    ```
3. Run the application:
    ```bash
    mvn spring-boot:run
    ```
Access the API at: http://localhost:8080/api/v1/hotels

## API Endpoints

| HTTP Method | Endpoint          | Description             | Request Body        |
|-------------|-------------------|-------------------------|---------------------|
| `POST`      | `/api/hotels`     | Add a new hotel         | Hotel JSON object   |
| `GET`       | `/api/hotels`     | Retrieve all hotels     | -                   |
| `GET`       | `/api/hotels/{id}`| Retrieve a single hotel | -                   |
| `PUT`       | `/api/hotels/{id}`| Update hotel details    | Hotel JSON object   |
| `DELETE`    | `/api/hotels/{id}`| Delete a hotel          | -                   |

---

## Example Hotel JSON Object
```json

{
  "name": "Grand Hotel",
  "email":"contact@grandhotel.com"
}
```