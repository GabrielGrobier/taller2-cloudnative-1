# Etapa 1: compilar con Maven 2026
FROM eclipse-temurin:21-jdk AS buildstage

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml .
COPY src /app/src

RUN mvn clean package -DskipTests

# Etapa 2: imagen final
FROM eclipse-temurin:21-jdk

COPY --from=buildstage /app/target/ms-secucloud-1.0.0.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
