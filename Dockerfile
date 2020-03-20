FROM openjdk:11.0.6-jre-slim

COPY target/*.jar /app.jar
ENV CONFIG_LOCATION=/config/
VOLUME /config

ENTRYPOINT [ "sh", "-c", "java -jar /app.jar"]
