FROM openjdk:17
COPY target/vacancy-storage-service.jar vacancy-storage-service.jar
ENTRYPOINT ["java", "-jar", "vacancy-storage-service.jar"]
