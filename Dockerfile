FROM eclipse-temurin:21
LABEL maintainer="moraism.dev@gmail.com"
WORKDIR /app
COPY target/*.jar word-processing-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "word-processing-service.jar"]
