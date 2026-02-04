# Use Maven image with JDK
FROM maven:3.9.5-eclipse-temurin-21

# Set working directory
WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the project and generate coverage report
RUN mvn clean package

# Expose Spring Boot and RMI ports
EXPOSE 8080
EXPOSE 1099

# Run the application
CMD ["java", "-jar", "target/calculator-backend-0.0.1-SNAPSHOT.jar"]
