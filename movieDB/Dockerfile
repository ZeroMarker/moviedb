# Stage 1: Build the Spring Boot application JAR
FROM maven:3-sapmachine-17 AS builder

WORKDIR /app

# Copy the project's POM file and download the dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the source code and build the application
COPY src src
RUN mvn package -DskipTests

# Stage 2: Create the final Docker image with the JAR
FROM openjdk:19

WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/movieDB.jar ./movieDB.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Define the command to run your Spring Boot application
CMD ["java", "-jar", "movieDB.jar"]
