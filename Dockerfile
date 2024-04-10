# Use a base Java image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the application JAR file
COPY target/lib1-0.0.1-SNAPSHOT.jar /app/

#command to set the classpath for mysql connector
CMD [ "java", "-cp", "lib1-0.0.1-SNAPSHOT.jar:mysql-connector-java.jar", "library_management.endresult" ]

# Expose the port your application runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "lib1-0.0.1-SNAPSHOT.jar"]