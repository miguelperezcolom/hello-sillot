FROM amazoncorretto:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
RUN echo "hello world"
ENTRYPOINT ["java", "-jar","/app.jar"]
