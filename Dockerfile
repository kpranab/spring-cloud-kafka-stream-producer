FROM openjdk:8
MAINTAINER Pranab
WORKDIR /workspace 
COPY target/spring-cloud-kafka-stream-producer-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","spring-cloud-kafka-stream-producer-0.0.1-SNAPSHOT.jar"]