FROM openjdk:11
EXPOSE 8082
ADD target/spring-boot-docker.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]