# Stage 1 - compile and build WAR
FROM maven:3.8.4-openjdk-8 AS backend-build
WORKDIR /todo-backend

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn clean install

# Stage 2 - create image
FROM tomcat:9.0.58-jre8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
ARG BUILD_PATH=/todo-backend/target
COPY --from=backend-build ${BUILD_PATH}/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]
