FROM openjdk:8-jdk-alpine
ADD  /target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
RUN ls -l
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]