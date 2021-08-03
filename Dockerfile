FROM openjdk:8-jdk-alpine
VOLUME /main-app
ADD ./target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]