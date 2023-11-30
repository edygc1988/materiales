# Usa una imagen base de Java 17
FROM eclipse-temurin:21-jdk-jammy

# Copia el archivo JAR de tu aplicación al contenedor
COPY ./target/materiales-0.0.1-SNAPSHOT.jar /app/materiales-0.0.1-SNAPSHOT.jar

# Especifica el comando para ejecutar la aplicación JAR
CMD ["java", "-jar", "/app/materiales-0.0.1-SNAPSHOT.jar"]

