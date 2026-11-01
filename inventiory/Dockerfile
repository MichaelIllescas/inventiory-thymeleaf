FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jre
COPY --from=build /app/target/inventiory-0.0.1.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"]
