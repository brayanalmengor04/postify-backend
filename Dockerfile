# Dockerfile para desarrollo con Spring Boot y OpenJDK 21
FROM openjdk:21-jdk-slim

ARG JAR_FILE=target/postify_backend-0.0.1.jar

COPY ${JAR_FILE} app_postify.jar
# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_postify.jar"]