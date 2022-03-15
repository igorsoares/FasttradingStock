# FROM maven:3.8.4-openjdk-17-slim as build
# WORKDIR /app
# COPY mvnw .
# COPY pom.xml .
# COPY src src
# RUN mvn package -DskipTests
# FROM openjdk:17
# COPY --from=build /app/target/*.jar app.jar
# EXPOSE 8082
# ENTRYPOINT java -jar -Djava.security.egd=file:/dev/./urandom -jar -XX:MinRAMPercentage=70 -XX:MaxRAMPercentage=90 -server -XX:+OptimizeStringConcat -XX:+UseStringDeduplication /app.jar


FROM openjdk:17.0.2-slim-buster
WORKDIR /app
COPY target/fasttrading_stocks-0.0.1-SNAPSHOT.jar app.jar
COPY src src
EXPOSE 8082
ENTRYPOINT java -jar -Djava.security.egd=file:/dev/./urandom -jar -XX:MinRAMPercentage=70 -XX:MaxRAMPercentage=90 -server -XX:+OptimizeStringConcat -XX:+UseStringDeduplication /app/app.jar
