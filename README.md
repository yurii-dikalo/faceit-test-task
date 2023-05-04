# 📝 Job Vacancies REST API 📝
## Project Description
Job Vacancies REST API is a simple application that allows you to upload and store job vacancies in an H2 database. This API supports the endpoints for getting a list of all vacancies sorted and with pagination, and getting a list of all vacancies counted and grouped by location. List of vacancies is being updated every hour by scheduler. The frequency of the scheduler can be adjusted.

## Supported Endpoints
These are implemented endpoints by this web application:

| HTTP METHOD | Endpoint                             | Description                                    |
|-------------|--------------------------------------|------------------------------------------------|
| GET         | /vacancies                           | Get the list of all vacancies sorted and with pagination. |
| GET         | /vacancies/group-by-location         | Get the list of all vacancies counted and grouped by location. |

## Technologies
- Java (JDK 17)
- Spring Boot 2.7.11
- Spring Data JPA
- H2
- Lombok
- Swagger
- Log4j2
- Apache Http Components

## How to Start the Application Locally
- Clone this repository and open it.
- Run the application in your IDE.
- Open your browser and navigate to http://localhost:8080/swagger-ui.html to access Swagger UI documentation.
- You can test the application endpoints using Swagger UI or any other REST client tool.
