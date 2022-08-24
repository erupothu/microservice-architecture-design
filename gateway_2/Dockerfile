FROM openjdk:8
EXPOSE 8001
ADD target/*.jar app.jar
ENTRYPOINT ["java", "-Xmx8096m", "-jar", "app.jar"]