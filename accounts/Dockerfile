# Start with a base image containing Java runtime
FROM openjdk:21-jdk-slim

#Information around who maintains the image
MAINTAINER Raveesha

#Add the applications jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Make port 8080 available to the world outside this container
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]

