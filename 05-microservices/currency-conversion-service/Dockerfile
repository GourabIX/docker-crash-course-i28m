# Stage 1 - compile and build source
FROM maven:3.8.4-openjdk-8 as backend-build
WORKDIR /currency-conversion-service
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src src
RUN mvn clean install

# Stage 2 - build image
FROM openjdk:8u322-jdk
VOLUME /tmp
EXPOSE 8100
COPY --from=backend-build /currency-conversion-service/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
