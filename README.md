# Runnerz - Spring Boot 3 Starter Project

Welcome to **Runnerz**, a Spring Boot 3 starter project designed to provide a foundational framework for building a
scalable and maintainable web application. This project is a great starting point for anyone looking to dive into the
world of Spring Boot development, particularly for those inspired by
the [Dan Vega's Spring Boot 3 tutorial](https://github.com/danvega/fcc-spring-boot-3)
and [associated video tutorial](https://www.youtube.com/watch?v=31KTdfRH6nY).

## About This Project

**Runnerz** serves as a simple yet flexible starting point for Spring Boot applications. It follows the common layered
architecture found in many Spring Boot applications, making it easy to extend and maintain over time. The project
currently includes one basic service, but it's designed to be built upon, so you can easily add more features and
complexity as needed.

## Code Structure/Architecture

The project adheres to a well-organized, layered architecture to ensure clean separation of concerns. Here's an overview
of the current structure:

- **Controller**: Handles incoming HTTP requests and routes them to the service layer.
- **Service**: Contains business logic and interacts with the data layer.
- **Data (Repository)**: Responsible for data access, interacting with the database.

This structure makes it easy to scale the project, add new services, and maintain clear boundaries between application
layers.

```plaintext
+-------Other world--------+
           |     ^
           v     |
+-------------------------+
|        Controller        |
+-------------------------+
           |     ^
           v     |
+-------------------------+
|         Service          |
+-------------------------+
           |     ^
           v     |
+-------------------------+
|      Data (Repository)   |
+-------------------------+

```

## Libraries Used

The **Runnerz** project leverages a couple of powerful libraries to streamline development and improve code quality:

- **Spring Data JDBC**: A simplified and lightweight approach to data persistence in Spring applications. It allows
  interaction with relational databases using minimal boilerplate code, while still retaining the benefits of Spring
  Data’s repository abstraction. Alternatives were considered, such as Spring Data JPA, JDBC client or even native JDBC
  API, but Spring Data JDBC was chosen for its simplicity and ease of use, as well as good abstraction.

- **MapStruct**: A code generator that simplifies the conversion of Java objects between different types, especially
  when mapping between entities and DTOs (Data Transfer Objects). MapStruct eliminates the need for manually writing
  cumbersome mapping logic, generating the mappers at compile-time for efficiency. In some cases we needed to provide
  some mapping by hand since MapStruct does not support working with immutable types, such as Java 17's ```record```
  classes.

These libraries help keep the code clean, efficient, and easier to maintain. As the project evolves, more libraries and
tools might be introduced to cover additional features.

## Future Enhancements

The current version of **Runnerz** is just the beginning! In future iterations, we plan to cover the following:

1. **Testing**: We'll add unit and integration tests to ensure the reliability and robustness of the codebase.
2. **Deployments**: Learn how to deploy this application to various platforms such as AWS, Heroku, or Kubernetes.
3. **Pipelines**: Automate builds, tests, and deployments using CI/CD tools like Jenkins, GitHub Actions, or GitLab CI.
4. **Authorization and Authentication**: Implement security mechanisms such as JWT or OAuth2 to control access and
   protect sensitive endpoints.

## Getting Started

1. **Clone the repository**:
    ```bash
    git clone https://github.com/AbdAllahAbdElFattah13/runnerz-spring-boot-3-starter.git
    cd runnerz-spring-boot-3-starter
    ```

2. **Build and run the application**:
    ```bash
    ./mvnw spring-boot:run
    ```

3. **Access the application**:
    - The app will be available at `http://localhost:8080`.

## Prerequisites

- Java 17+
- Maven 3.8+
- Spring Boot 3.x

## Contributing

Contributions are welcome! Feel free to fork the project, submit issues, or open pull requests to help improve the
project and add new features.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
