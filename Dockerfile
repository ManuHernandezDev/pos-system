# Usar imagen de Java
FROM openjdk:17-jdk-slim

# Copiar proyecto
COPY target/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Ejecutar app
ENTRYPOINT ["java","-jar","/app.jar"]
