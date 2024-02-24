#
# Build stage
#
FROM maven:3-openjdk-17 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM amazoncorretto:17-alpine3.17-jdk
COPY --from=build /target/*.jar app.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]