### Stage 1 - Lets build the "deployable package"

FROM maven:3.8.4-openjdk-8 as backend-build
WORKDIR /fullstack/backend

### Step 1.1 - Copy pom.xml and download project dependencies

# Dividing copy into two steps to ensure that we download dependencies only when pom.xml changes
COPY pom.xml .
# dependency:go-offline - Goal that resolves all project dependencies, 
# including plugins and reports and their dependencies. -B -> Batch mode
RUN mvn dependency:go-offline -B

### Step 1.2 - Copy source and build "deployable package"
COPY src src
RUN mvn clean install

### Step 1.3- Unzip the JAR
# jar -xf unzips the JAR into the current directory.
# -p switch stands for --parents. This would prevent errors if parent directories already exist. Directories will be created as required.
# fire "man mkdir" command on an UNIX terminal for more info.
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

### Stage 2 - Let's build a minimal image with the "deployable package"
FROM openjdk:8u322-jdk
VOLUME /tmp
ARG DEPENDENCY=/fullstack/backend/target/dependency
COPY --from=backend-build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=backend-build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=backend-build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.in28minutes.rest.webservices.restfulwebservices.RestfulWebServicesApplication"]
