FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/taxis-0.0.1.jar
COPY ${JAR_FILE} app_taxis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_taxis.jar"]