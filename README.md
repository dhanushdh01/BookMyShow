# BookMyShow Backend Project

This project is a backend application for a BookMyShow-like ticket booking platform. It is built using Java, Spring Boot, and SQL. Maven is used for project management, and Postman is used for API testing.

## Introduction

The BookMyShow backend project provides a comprehensive set of APIs to manage movies, theaters, shows, and bookings. It serves as the backbone for a ticket booking platform where users can browse movies, check show timings, and book tickets.

## Features

- User authentication and authorization
- Movie management (CRUD operations)
- Theater management (CRUD operations)
- Show management (CRUD operations)
- Booking management
- Search functionality for movies and shows
- Integration with Postman for API testing

## Technologies Used

- Java
- Spring Boot
- SQL (MySQL/PostgreSQL)
- Maven
- Postman

## Installation

### Prerequisites

- Java 8 or higher
- Maven
- MySQL/PostgreSQL

### Steps

1. Clone the repository:
    ```bash
    git clone https://github.com/dhanushdh01/BookMyShow.git
    cd BookMyShow
    ```

2. Configure the database:
    - Create a database named `bookmyshow`.
    - Update the database configuration in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/bookmyshow
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Build the project:
    ```bash
    mvn clean install
    ```

4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Usage

### Running the Application

Once the application is up and running, you can access the API at `http://localhost:8080`.


### Example Requests

#### Create a Movie


POST /api/movies
Content-Type: application/json

{
  "title": "Inception",
  "genre": "Sci-Fi",
  "duration": 148
}

Get All Movies

GET /api/movies


Create a Booking


POST /api/bookings
Content-Type: application/json

{
  "userId": 1,
  "showId": 2,
  "seats": [ "A1", "A2" ]
}
## Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes. Ensure that your code adheres to the project's coding standards and passes all tests.
