FROM maven:3.8.1-openjdk-17
USER nobody
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]