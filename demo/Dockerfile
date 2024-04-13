FROM openjdk:17.0.1-jdk-slim
EXPOSE 8088
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-boot-docker-app.jar
#ADD target/spring-boot-docker-app.jar spring-boot-docker-app.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker-app.jar"]