FROM maven:3.6.3 AS build-dependency
WORKDIR /opt/app
COPY . .

RUN mvn -B -e clean package -DskipTests=true

FROM adoptopenjdk/openjdk11:alpine-jre
# FROM openjdk:8-jre-alpine

WORKDIR /opt/app
RUN addgroup --system soa  && adduser -S -s /bin/false -G soa soa
RUN chown -R soa:soa /opt/app
USER soa
COPY --from=build-dependency opt/app/target/*.jar .

EXPOSE 8081

ENTRYPOINT java -jar /opt/app/*.jar
