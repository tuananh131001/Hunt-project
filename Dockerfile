FROM amazoncorretto:17 as timeline-service
ARG JAR_FILE=target/timeline-service-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]

EXPOSE 8080