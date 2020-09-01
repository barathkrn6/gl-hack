FROM openjdk:8
#FROM frolvlad/alpine-oraclejdk8:slim
ADD target/hack-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]