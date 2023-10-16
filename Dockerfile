FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package -DskipTests

FROM openjdk:17
WORKDIR accountdemo
COPY --from=build target/*.jar accountdemo.jar
ENTRYPOINT ["java", "-jar", "accountdemo.jar"]