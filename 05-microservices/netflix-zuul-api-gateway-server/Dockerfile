# Stage 1 - compile and build source
FROM maven:3.8.4-openjdk-8 AS backend-build
WORKDIR /zuul-api-gateway-server
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src src
RUN mvn clean install

# Stage 2 - build image
# Use a JDK, not a JRE.
FROM openjdk:8u322-jre
VOLUME /tmp
EXPOSE 8100
COPY --from=backend-build /zuul-api-gateway-server/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
