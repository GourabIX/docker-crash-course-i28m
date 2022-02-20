# Stage 1 - compile and build source
FROM maven:3.8.4-openjdk-8 AS backend-build
WORKDIR /eureka-naming-server
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src src
RUN mvn clean install

# Stage 2 - build image
# Use a JRE, not a JDK.
FROM openjdk:8u322-jre
EXPOSE 8761
COPY --from=backend-build /eureka-naming-server/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
