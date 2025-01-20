# Waste Sorting API 🌱

## Overview
The Waste Sorting API is a Spring Boot application developed for Enviro365, designed to promote sustainable waste management practices. It serves as the backend system for a mobile application that provides guidance on proper waste disposal techniques and encourages recycling habits.

![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen.svg)  
![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Maven](https://img.shields.io/badge/Maven-3.6.0-blue)
![H2 Database](https://img.shields.io/badge/Database-H2%20In--Memory-yellowgreen.svg)
![Swagger](https://img.shields.io/badge/Swagger-UI%20Available-brightblue.svg)
![Spring Boot Actuator](https://img.shields.io/badge/Spring%20Boot%20Actuator-Enabled-orange.svg)
![API Version](https://img.shields.io/badge/API%20Version-v1.0.0-brightgreen)
![Commit Activity](https://img.shields.io/github/commit-activity/w/Xolani-M/waste-sorting-api)
![Platform](https://img.shields.io/badge/Platform-Linux%20%2F%20Windows%20%2F%20macOS-brightgreen)
![License](https://img.shields.io/badge/License-Dummy%20License-blue.svg)
![Port](https://img.shields.io/badge/Port-9000-blue.svg)








---

## Table of Contents
- [Key Features](#key-features)
- [Tech Stack](#tech-stack)
- [Dependencies](#dependencies)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Environment Setup](#environment-setup)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
    - [Endpoints Overview](#endpoints-overview)
    - [Request/Response Examples](#requestresponse-examples)
- [Data Models](#data-models)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [Monitoring](#monitoring)
- [Deployment](#deployment)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Key Features 🚀
- Comprehensive waste category management system
- Detailed disposal guidelines and educational recycling tips
- RESTful API with CRUD operations
- Input validation and error handling
- In-memory H2 database for rapid development
- Interactive API documentation with Swagger UI
- Spring Boot Actuator for monitoring and metrics

---

## Tech Stack 💻
### Core
- Java 17
- Spring Boot 3.4.1
- Spring Data JPA
- Spring Validation
- Spring Boot Actuator

### Database
- H2 Database (In-memory)
- JPA/Hibernate

### Documentation
- Springdoc OpenAPI 2.8.3
- Swagger UI

### Development Tools
- Maven
- Spring Boot DevTools
- Git
---

## Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.8.3</version>
    </dependency>
</dependencies>
```

---

## Project Structure 📁
```
src/
├── main/
│   ├── java/
│   │   └── com/enviro/assessment/grad001/xolani/mvana/waste_sorting_api/
│   │       ├── controller/
│   │       │   ├── DisposalGuidelineController.java
│   │       │   ├── HomeController.java
│   │       │   ├── RecyclingTipController.java
│   │       │   └── WasteCategoryController.java
│   │       ├── dto/
│   │       │   ├── DisposalGuidelineDTO.java
│   │       │   ├── RecyclingTipDTO.java
│   │       │   └── WasteCategoryDTO.java
│   │       ├── model/
│   │       │   ├── DisposalGuideline.java
│   │       │   ├── RecyclingTip.java
│   │       │   └── WasteCategory.java
│   │       ├── repository/
│   │       │   ├── DisposalGuidelineRepo.java
│   │       │   ├── RecyclingTipRepo.java
│   │       │   └── WasteCategoryRepo.java
│   │       └── service/
│   │           ├── DisposalGuidelineService.java
│   │           ├── RecyclingTipService.java
│   │           └── WasteCategoryService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/enviro/assessment/grad001/xolani/mvana/waste_sorting_api/
            └── [test classes]
```

---

## Getting Started 🚀

### Prerequisites
- Java JDK 17 or higher
- Maven 3.6 or higher
- Git

### Environment Setup
1. Install Java 17:
```bash
# For Ubuntu
sudo apt install openjdk-17-jdk

# For macOS
brew install openjdk@17
```
2. Install Maven:
```bash
# For Ubuntu
sudo apt install maven

# For macOS
brew install maven
```
3. Verify installations:
```bash
java -version
mvn -version
```

### Installation
1. Clone the repository:
```bash
git clone https://github.com/Xolani-M/waste-sorting-api.git
cd waste-sorting-api
```
2. Build the project:
```bash
mvn clean install
```

### Running the Application
1. Development mode:
```bash
mvn spring-boot:run
```
2. Production mode:
```bash
java -jar target/waste-sorting-api-0.0.1-SNAPSHOT.jar
```

---

## API Documentation 📚

### Base URLs
- Local: `http://localhost:9000`
- Swagger UI: `http://localhost:9000/swagger-ui.html`
- H2 Console: `http://localhost:9000/h2-console`

### Swagger Notes 📝
For **POST** requests, it is recommended to use the example request bodies provided below, rather than the default ones displayed in Swagger UI. These examples:

- Ensure compatibility with the application’s **validation rules**.
- Align with the **expected data structure** for seamless processing.
- Help avoid common issues such as:
    - Missing required fields.
    - Incorrect data types.
    - Failing validation constraints.

### Endpoints Overview
#### Waste Categories
| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| GET    | `/api/waste-categories` | List all categories      |
| POST   | `/api/waste-categories` | Create a category        |
| GET    | `/api/waste-categories/{id}` | Get category by ID       |
| PUT    | `/api/waste-categories/{id}` | Update category          |
| DELETE | `/api/waste-categories/{id}` | Delete category          |

#### Disposal Guidelines
| Method | Endpoint                    | Description              |
|--------|-----------------------------|--------------------------|
| GET    | `/api/disposal-guidelines`  | List all guidelines      |
| POST   | `/api/disposal-guidelines`  | Create a guideline       |
| GET    | `/api/disposal-guidelines/{id}` | Get guideline by ID    |
| PUT    | `/api/disposal-guidelines/{id}` | Update guideline       |
| DELETE | `/api/disposal-guidelines/{id}` | Delete guideline       |

#### Recycling Tips
| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| GET    | `/api/recycling-tips`   | List all tips            |
| POST   | `/api/recycling-tips`   | Create a tip             |
| GET    | `/api/recycling-tips/{id}` | Get tip by ID           |
| PUT    | `/api/recycling-tips/{id}` | Update tip              |
| DELETE | `/api/recycling-tips/{id}` | Delete tip              |




### Request/Response Examples

#### Create Waste Category
**Request:**
```json
POST /api/waste-categories
{
  "name": "Plastic",
  "description": "Items made from plastic materials"
}
```

**Response:**
**Status:** `200 Created`
```json
{
  "id": 1,
  "name": "Plastic",
  "description": "Items made from plastic materials"
}
```

---

#### Create Disposal Guideline
**Request:**
```json
POST /api/disposal-guidelines
{
  "instruction": "Rinse thoroughly before disposing.",
  "wasteCategoryId": 1
}
```

**Response:**
**Status:** `200 Created`
```json
{
  "id": 3,
  "instruction": "Rinse thoroughly before disposing.",
  "wasteCategoryId": 1
}
```

---

#### Create Recycling Tip
**Request:**
```json
POST /api/recycling-tips
{
  "tip": "Separate plastic and paper waste.",
  "description": "Proper separation improves recycling efficiency."
}
```

**Response:**
**Status:** `201 Created`
```json
{
  "id": 1,
  "tip": "Separate plastic and paper waste.",
  "description": "Proper separation improves recycling efficiency."
}
```

---

## Data Models 📊

### WasteCategory
```json
{
  "id": "Integer",
  "name": "String",
  "description": "String"
}
```

### DisposalGuideline
```json
{
  "id": "Integer",
  "instruction": "String",
  "wasteCategoryId": "Integer"
}
```

### RecyclingTip
```json
{
  "id": "Integer",
  "tip": "String",
  "description": "String"
}
```

---


## Error Handling 🔧
The API uses standard HTTP response codes:
- 200: Success
- 201: Created
- 400: Bad Request
- 404: Not Found
- 500: Internal Server Error

Error Response Format:
```json
{
  "timestamp": "2025-01-20T10:30:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Invalid input",
  "path": "/api/waste-categories"
}
```

## Testing 🧪
Run tests using:
```bash
mvn test
```

---

## Monitoring 📊
Spring Boot Actuator endpoints:
- Health check: `http://localhost:9000/actuator/health`
- Metrics: `http://localhost:9000/actuator/metrics`

---

## Deployment 🚀
1. Build the JAR:
```bash
mvn clean package
```
2. Run in production:
```bash
java -jar target/waste-sorting-api-0.0.1-SNAPSHOT.jar
```

---

## Troubleshooting 🔍

1. Application won't start
```bash
# Check port availability
netstat -ano | findstr :9000
```

2. Database connectivity issues
```bash
# Verify H2 console accessibility
http://localhost:9000/h2-console
```

---

## Contributing 🤝
1. Fork the repository
2. Create your feature branch: `git checkout -b feature/AmazingFeature`
3. Commit your changes: `git commit -m 'Add AmazingFeature'`
4. Push to the branch: `git push origin feature/AmazingFeature`
5. Open a Pull Request

---

## License 📝
[Dummy Licence](LICENSE)

---

## Contact 📧
Project Maintainer: Xolani the sageNinja   
Email: nathanielmvana@gmail.com  
LinkedIn: www.linkedin.com/in/xolani-mvana-3ba0a616b

---

Made with ❤️ by Xolani for Enviro365

