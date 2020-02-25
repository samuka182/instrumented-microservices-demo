FROM maven:3.6.3-jdk-13 AS MAVEN_BUILD
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn package

FROM openjdk:13-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY --from=MAVEN_BUILD /build/${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]