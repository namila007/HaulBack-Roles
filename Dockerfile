FROM openjdk:8-jdk-alpine
CMD ["/usr/bin/bash", "gradlew", "bootjar"]
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080