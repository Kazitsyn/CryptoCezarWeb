FROM openjdk:17-alpine
COPY /target/CryptoCezarWeb-0.0.1-SNAPSHOT.jar /usr/src/my-app/my-app-1.0.0.jar
WORKDIR /usr/src/my-app
EXPOSE 8080
CMD ["java", "-jar", "my-app-1.0.0.jar"]


