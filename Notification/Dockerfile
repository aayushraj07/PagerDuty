# Stage 1: Build the application using Maven with Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of your source code
COPY src ./src

# Package the application into a JAR file
RUN mvn clean package -DskipTests

# Stage 2: Create the final, lightweight image with Java 21 JRE
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Notification service will listen on
EXPOSE 8083

# Command to run the service
ENTRYPOINT ["java", "-jar", "app.jar"]