FROM maven:3.8.4-jdk-11-slim AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean install -Dmaven.test.skip=true -q

FROM lpicanco/java11-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/todoapp-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "todoapp-0.0.1-SNAPSHOT.jar"]