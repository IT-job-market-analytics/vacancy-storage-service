FROM maven:3.9.1-eclipse-temurin-17-alpine AS build
COPY /src /src
COPY pom.xml /
RUN mvn -f /pom.xml clean package

FROM eclipse-temurin:17-jre
WORKDIR /
COPY --from=build /target/*.jar vacancy-storage-service.jar
ENTRYPOINT ["java", "-jar", "vacancy-storage-service.jar"]
