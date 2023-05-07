FROM --platform=linux/amd64 maven:3.8.4-openjdk-17 as build
WORKDIR /hexagon-root
RUN mvn clean package -DskipTests=true

FROM --platform=linux/amd64 openjdk:17-alpine
WORKDIR /hexagon-root
ARG HEXAGON_DOMAIN_JAR=/hexagon-domain/target/*.jar
ARG HEXAGON_API_JAR=/hexagon-api/target/*.jar
ARG HEXAGON_EXTERNAL_JAR=/hexagon-external/target/*.jar
ARG HEXAGON_SHARED_JAR=/hexagon-shared/target/*.jar
ARG HEXAGON_ADAPTER_JAR=/hexagon-adapter/target/*.jar
ARG HEXAGON_INFRASTRUCTURE_JAR=/hexagon-infrastructure/target/*.jar
COPY ${HEXAGON_DOMAIN_JAR} hexagon-domain.jar
COPY ${HEXAGON_API_JAR} hexagon-api.jar
COPY ${HEXAGON_EXTERNAL_JAR} hexagon-external.jar
COPY ${HEXAGON_SHARED_JAR} hexagon-shared.jar
COPY ${HEXAGON_ADAPTER_JAR} hexagon-adapter.jar
COPY ${HEXAGON_INFRASTRUCTURE_JAR} hexagon-infrastructure.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=production","/hexagon-root/hexagon-infrastructure.jar"]
