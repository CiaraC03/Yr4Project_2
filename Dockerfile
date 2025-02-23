# Use an official jdk as a parent
FROM  openjdk:17-jdk

# Set the working directory in the container
WORKDIR /Yr4Project_2

# Copy the built application JAR file from your local machine to the container
COPY target/*.jar Yr4Project_2.jar

# Mkae port 8081 available to the world outside this container
EXPOSE 8081

# run the jar file
ENTRYPOINT ["java", "-jar", "Yr4Project_2.jar"]