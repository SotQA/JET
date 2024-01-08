FROM openjdk:17-jdk-slim

ARG JAR_FILE=/target/SF-1.0-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]