# Spring Security Example

This project is a Spring Boot application that demonstrates the implementation of Spring Security for securing endpoints with custom user details and roles. The application includes examples of both admin and employee roles, and their associated functionalities.

## Table of Contents

- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

### Prerequisites

Before you begin, ensure you have the following installed:

- Java 11 or higher
- Maven 3.6.3 or higher
- An IDE such as IntelliJ IDEA, Eclipse, or VS Code

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/Harshyadav02/Spring-Security.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Spring-Security
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the application:
    ```bash
    mvn spring-boot:run
    ```

## Project Structure
``` sh
.
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── harsh
    │   │           └── springSecurity
    │   │               ├── Controller
    │   │               │   ├── AdminController.java
    │   │               │   └── EmployeeController.java
    │   │               ├── Entity
    │   │               │   ├── Admin.java
    │   │               │   └── Employee.java
    │   │               ├── Repository
    │   │               │   ├── AdminRepo.java
    │   │               │   └── EmployeeRepo.java
    │   │               ├── Security
    │   │               │   ├── PasswordConfig.java
    │   │               │   ├── SecurityConfig.java
    │   │               │   └── UserDetailsServiceImp.java
    │   │               ├── Service
    │   │               │   ├── AdminService.java
    │   │               │   └── EmployeeService.java
    │   │               └── SpringSecurityApplication.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── harsh
                    └── springSecurity
                        └── SpringSecurityApplicationTests.java

```

### Directory Breakdown

- **Controller**: Contains the REST controllers (`AdminController`, `EmployeeController`) responsible for handling HTTP requests.
- **Entity**: Includes the entity classes (`Admin`, `Employee`) that map to the database tables.
- **Repository**: Interfaces extending `CrudRepository` to interact with the database.
- **Security**: Holds the Spring Security configuration files (`PasswordConfig`, `SecurityConfig`) and custom `UserDetailsServiceImp`.
- **Service**: Service layer containing business logic for admins and employees.
- **SpringSecurityApplication.java**: The main class that bootstraps the Spring Boot application.
- **resources**: Contains configuration files like `application.properties`, static assets, and Thymeleaf templates.
- **test**: Unit tests for the application.

## Configuration

The application is configured using the `application.properties` file located in the `src/main/resources` directory. You can set your database configurations, server port, and other properties here.

## Security

This project demonstrates the use of Spring Security for securing REST endpoints. The key components are:

- **PasswordConfig.java**: Configures the password encoder (BCrypt in this case).
- **SecurityConfig.java**: Configures the HTTP security, roles, and user authentication mechanisms.
- **UserDetailsServiceImp.java**: A custom implementation of `UserDetailsService` that loads user-specific data.

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License

This README file is designed to be comprehensive and helpful for anyone who wants to understand the project and how to work with it. You can adjust the URLs and specifics according to your actual repository and project details.

