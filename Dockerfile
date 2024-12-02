FROM openjdk:21-jdk-slim-buster

MAINTAINER Shubham

COPY target/Backend-core-0.0.1-SNAPSHOT.jar Backend-core-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java" , "-jar", "Backend-core-0.0.1-SNAPSHOT.jar"]
