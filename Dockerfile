#From maven image
FROM maven:3.9.9-eclipse-temurin-17-focal AS build

#create working directory
WORKDIR /app

#Clone Project
COPY . /app

#COMMAND
RUN  mvn clean package -DskipTests

#From java
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

#Exposing endpoint
EXPOSE 8080

#Run a application
CMD ["java","-jar","app.jar"]



