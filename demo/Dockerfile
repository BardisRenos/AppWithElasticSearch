FROM openjdk:17.0.1
EXPOSE 8088
ARG JAR_FILE=target/*.jar
ARG PORT=8088
COPY ${JAR_FILE} spring-boot-docker-app.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker-app.jar", "--server.port=${PORT}"]