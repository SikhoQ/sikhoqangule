# Sikho Qangule Waste Management API

A Spring Boot-based RESTful API for managing waste categories and associated disposal guidelines and recycling tips. This application is designed to promote sustainable waste management practices by providing endpoints for retrieving, creating, updating, and deleting waste-related data.

---

## **Features**

- RESTful API endpoints for:
  - Waste Categories
  - Disposal Guidelines
  - Recycling Tips
- Integration with H2 in-memory database for persistence.
- Validation of incoming data using Spring Boot Validation.
- Exception handling with structured error responses.
- Utilizes **Lombok** for reducing boilerplate code.
- Follows best practices, including the MVC architecture.

---

## **Technologies Used**

- **Java**: JDK 23
- **Spring Boot**: 3.4.1
  - Spring Data JPA
  - Spring Web
  - Spring Boot Validation
- **H2 Database**: In-memory database for development and testing.
- **Lombok**: For concise code and automated getters, setters, and constructors.
- **Maven**: Build and dependency management tool.

---

## **Getting Started**

### **Prerequisites**

1. Java 17 or higher (ensure `JAVA_HOME` is correctly configured).
   
   ```bash
   java -version
   ```

2. Maven 3.6+ installed on your system.
   
   ```bash
   mvn -version
   ```

3. IDE (e.g., IntelliJ IDEA or Eclipse) with Lombok support enabled.
   
   - Install the Lombok plugin if prompted.

---

### **Installation**

1. Clone the repository:
   
   ```bash
   git clone git@github.com:SikhoQ/sikhoqangule.git
   cd sikhoqangule
   ```

2. Build the project:
   
   ```bash
   make build
   ```

3. Run the application:
   
   ```bash
   make run
   ```

---

## **Endpoints**

### **Waste Categories**

| Method   | Endpoint               | Description                   | Request Body                               |
| -------- | ---------------------- | ----------------------------- | ------------------------------------------ |
| `GET`    | `/api/categories`      | Get all waste categories      | None                                       |
| `GET`    | `/api/categories/{id}` | Get a waste category by ID    | None                                       |
| `POST`   | `/api/categories`      | Create a new waste category   | `{ "name": "Paper", "description": "..."}` |
| `PUT`    | `/api/categories/{id}` | Update an existing category   | `{ "name": "Updated Name" }`               |
| `DELETE` | `/api/categories/{id}` | Delete a waste category by ID | None                                       |

### **Disposal Guidelines**

| Method   | Endpoint               | Description                    | Request Body                             |
| -------- | ---------------------- | ------------------------------ | ---------------------------------------- |
| `GET`    | `/api/guidelines`      | Get all disposal guidelines    | None                                     |
| `GET`    | `/api/guidelines/{id}` | Get a disposal guideline by ID | None                                     |
| `POST`   | `/api/guidelines`      | Create a disposal guideline    | `{ "description": "Place in blue bin" }` |
| `DELETE` | `/api/guidelines/{id}` | Delete a disposal guideline    | None                                     |

### **Recycling Tips**

| Method   | Endpoint         | Description               | Request Body                                   |
| -------- | ---------------- | ------------------------- | ---------------------------------------------- |
| `GET`    | `/api/tips`      | Get all recycling tips    | None                                           |
| `GET`    | `/api/tips/{id}` | Get a recycling tip by ID | None                                           |
| `POST`   | `/api/tips`      | Create a recycling tip    | `{ "tip": "Separate waste before recycling" }` |
| `DELETE` | `/api/tips/{id}` | Delete a recycling tip    | None                                           |

---

## **Testing**

### **Run Unit Tests**

Run tests with Maven:

```bash
make test
```

### **Test Frameworks**

- **JUnit 5**: For unit and integration tests.
- **MockMvc**: For testing REST controllers.
- **Mockito**: For mocking dependencies.

---

## **Database**

The application uses an H2 in-memory database during runtime. You can access the H2 Console at:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: *(leave blank)*

---

## **Error Handling**

The API provides structured error responses for various scenarios:

### Example Response for Not Found:

```json
{
  "timestamp": "2025-01-27T12:34:56",
  "status": 404,
  "error": "Not Found",
  "message": "Waste Category not found with id: 123",
  "path": "/api/categories/123"
}
```

---

## **Contributing**

1. Fork the repository.

2. Create a feature branch:
   
   ```bash
   git checkout -b feature/my-new-feature
   ```

3. Commit your changes:
   
   ```bash
   git commit -m "Add some feature"
   ```

4. Push to the branch:
   
   ```bash
   git push origin feature/my-new-feature
   ```

5. Open a pull request.

---

## **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---


