FROM maven:3.8.4-openjdk-17-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean install -Dmaven.test.skip=true -q

FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/todoapp-0.0.1.jar /app/
ENTRYPOINT ["java", "-jar", "todoapp-0.0.1.jar"]