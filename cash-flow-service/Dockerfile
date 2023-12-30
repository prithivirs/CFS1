# Use an official OpenJDK runtime as a parent image
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container at /app
COPY target/cash-flow-service-1.0.0.jar /app/cash-flow-service-1.0.0.jar

# Set environment variables for logging and server properties
ENV LOGGING_FILE=logs/dev_app.log \
    LOGGING_PATTERN_CONSOLE="%d %-5level %logger : %msg%n" \
    LOGGING_PATTERN_FILE="%d %-5level [%thread] %logger : %msg%n" \
    SERVER_PORT=9011 \
    SERVER_SESSION_TIMEOUT=6000 \
    SERVER_CONNECTION_TIMEOUT=120000 \
    SERVER_SERVLET_CONTEXT_PATH=/cash-flow-service \
    SPRING_DATASOURCE_URL=jdbc:mysql://172.17.0.2/CFS?useUnicode=yes&characterEncoding=UTF-8 \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=root \
    SPRING_DATASOURCE_DRIVER-CLASS-NAME=com.mysql.cj.jdbc.Driver \
    SPRING_DATASOURCE_TESTONBORROW=true \
    SPRING_JPA_DATABASE-PLATFORM=org.hibernate.dialect.MySQL57Dialect \
    SPRING_JPA_SHOW-SQL=true \
    SPRING_JPA_HIBERNATE_DDL-AUTO=none \
    SPRING_JPA_GENERATE-DDL=false \
    SPRING_JPA_PROPERTIES_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE=false \
    SPRING_JPA_PROPERTIES_HIBERNATE_CACHE_USE_QUERY_CACHE=false \
    SPRING_JPA_PROPERTIES_HIBERNATE_CACHE_USE_STRUCTURED_ENTRIES=false \
    SPRING_JPA_PROPERTIES_HIBERNATE_CACHE_USE_MINIMAL_PUTS=false \
    SPRING_JPA_PROPERTIES_HIBERNATE_CACHE_GENERATE_STATISTICS=false \
    AWS_UPLOAD=false \
    DOCUMENT_UPLOAD_FILE_PATH=/home/vagrant/images \
    DOCUMENT_LOCAL_UPLOAD_FILE_PATH=/home/vagrant/images \
    DOCUMENT_PERMITTED_CONTENT_TYPES=application/pdf

# Expose the application port
EXPOSE 9011
# Adding the jar
#ADD target/cash-flow-service-1.0.0.jar cash-flow-service-1.0.0.jar
# Run the application when the container starts
CMD ["java", "-jar", "/app/cash-flow-service-1.0.0.jar","--spring.datasource.validationQuery=SELECT 1"]
