FROM openjdk:17-alpine
EXPOSE 8088
ADD target/spring-boot-docker-app.jar spring-boot-docker-app.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker-app.jar"]