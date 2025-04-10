# Application Web Distribuée 🌐

Ce projet est une application web distribuée composée de plusieurs microservices, développée avec Spring Boot, Angular, et d'autres technologies modernes. Elle utilise **Eureka** pour la découverte des services et **API Gateway** pour la gestion des requêtes.

---

## Table des matières 📋

1. [Technologies utilisées ⚙️](#technologies-utilisées-⚙️)
2. [Structure du projet 🏗️](#structure-du-projet-🏗️)
3. [Prérequis 🛠️](#prérequis-🛠️)
4. [Installation 📦](#installation-📦)
5. [Lancement des services 🚀](#lancement-des-services-🚀)
6. [Endpoints principaux 🖥️](#endpoints-principaux-🖥️)
7. [Contributeurs 🤝](#contributeurs-🤝)

---

## Technologies utilisées ⚙️

- **Backend :** Java, Spring Boot, Maven
- **Frontend :** Angular, TypeScript
- **Base de données :** MongoDB
- **Gestion des microservices :**
  - Eureka (Service Discovery) 🔍
  - Spring Cloud Gateway (API Gateway) 🌐
  - Resilience4j (Circuit Breaker) 🔄
- **Conteneurisation :** Docker 🐳

---

## Structure du projet 🏗️

Voici les principaux modules du projet :

- **Eureka-Server** : Serveur Eureka pour la découverte des services. 🔍
- **API_Gateway** : Passerelle API pour la gestion des requêtes. 🚪
- **Reclamation_Service** : Microservice pour la gestion des réclamations. 📝
- **Angular-Frontend** : Interface utilisateur développée avec Angular. 💻

---

## Prérequis 🛠️

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- **Java** 17 ou version supérieure ☕
- **Maven** (pour la gestion des dépendances backend) 📦
- **Node.js** et **npm** (pour le frontend Angular) 🌱
- **Docker** (pour la conteneurisation) 🐳
- **MongoDB** (base de données) 🗄️

---

## Installation 📦

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/Application-Web-Distribution-Project/Micro-Service-Wael.git
