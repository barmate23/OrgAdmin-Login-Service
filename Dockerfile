# syntax=docker/dockerfile:1

# ======================
# Build stage
# ======================
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app

# First copy pom.xml and download dependencies (better cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code
COPY src src

# Build the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# ======================
# Run stage
# ======================
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy only the built jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
