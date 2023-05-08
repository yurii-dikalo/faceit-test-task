# 📝 Job Vacancies REST API 📝
## Project Description
Job Vacancies REST API is a simple application that allows you to upload and store job vacancies in an H2 database. This API supports several endpoints, including retrieving a sorted and paginated list of all vacancies, retrieving detailed information about a vacancy by its ID, retrieving a list of the most visited vacancies' IDs, and retrieving a count of all vacancies grouped by location. The list of vacancies is updated on an hourly basis by a scheduler, and the frequency of the scheduler can be adjusted according to your needs.

## Supported Endpoints
These are implemented endpoints by this web application:

| HTTP METHOD | Endpoint                     | Description                                              |
|-------------|------------------------------|----------------------------------------------------------|
| GET         | /vacancies                   | Retrieve a sorted and paginated list of all vacancies.   |
| GET         | /vacancies/{id}              | Retrieve detailed information about a vacancy by its ID. |
| GET         | /vacancies/top-vacancies     | Retrieve a list of the most visited vacancies' IDs.      |
| GET         | /vacancies/group-by-location | Retrieve a count of all vacancies grouped by location.   |

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
