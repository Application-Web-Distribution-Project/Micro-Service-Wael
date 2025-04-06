# Utiliser une image de base avec OpenJDK
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier .jar généré (assurez-vous qu'il est généré au préalable)
COPY target/Eureka-Server-0.0.1-SNAPSHOT.jar /app/eureka-server.jar

# Exposer le port que Eureka utilise
EXPOSE 8761

# Lancer l'application Eureka
CMD ["java", "-jar", "/app/eureka-server.jar"]
