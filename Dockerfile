FROM maven:3.9.1-eclipse-temurin-17-alpine
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package

FROM openjdk:17
WORKDIR /
COPY --from=build /target/*.jar vacancy-storage-service.jar
ENTRYPOINT ["java", "-jar", "vacancy-storage-service.jar"]
