FROM maven:3.9.9-eclipse-temurin-17-alpine as build
COPY src ./src
COPY pom.xml .
RUN mvn package -DskipTests

FROM alpine:3.20.3 as deploy
RUN apk add openjdk17
RUN addgroup -S javapp_user && adduser -S javapp_user -G javapp_user
USER javapp_user
WORKDIR /java/target
COPY --from=build target/testAppLab1-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar"]
CMD ["testAppLab1-0.0.1-SNAPSHOT.jar"]