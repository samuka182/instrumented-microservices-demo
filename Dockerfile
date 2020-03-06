FROM maven:3.6.3-jdk-13 AS MAVEN_BUILD
COPY pom.xml /build/
COPY address/pom.xml /build/address/pom.xml
COPY address/src /build/address/src
COPY commons-service/pom.xml /build/commons-service/pom.xml
COPY commons-service/src /build/commons-service/src
WORKDIR /build/
RUN mvn package

FROM openjdk:13-jdk-alpine
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY --from=MAVEN_BUILD /build/address/${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]