# widgetCitations

## Table of contents
1. [Introduction](#1-introduction)
2. [Tools using](#2-tools-using)
3. [Architecture](#3-architecture)
4. [Features list](#4-features-list)
5. [How to launch ?](#5-how-to-launch-)
<!-- 6. [Preview](#6-preview) -->

---

## 1. Introduction

**widgetCitations** is a full-stack Android project made up of two modules:

- **`citations-api`** — a Spring Boot REST API that serves random quotes stored in a PostgreSQL database
- **`widCitations`** — an Android home screen widget that fetches and displays a quote from the API

---

## 2. Tools using

**Backend (`citations-api`)**
- **Java** — main language
- **Spring Boot** — REST API framework
- **Spring Data JPA** — database access
- **PostgreSQL** — quote storage
- **Docker / Docker Compose** — containerized database

**Frontend (`widCitations`)**
- **Java** — Android development
- **Android SDK** — widget system (`AppWidgetProvider`)
- **HTTP client** — API calls from the widget

---

## 3. Architecture

```
widgetCitations/
├── citations-api/        # Spring Boot REST API
│   └── ...               # Controllers, Services, Repositories, Entities
└── widCitations/         # Android application
    └── ...               # Widget provider, layout, manifest
```

The Android widget calls the REST API on a set interval to retrieve a random quote and display it on the home screen.

---

## 4. Features list

- REST API endpoint returning a random quote from the database
- PostgreSQL database managed via Docker
- Android home screen widget displaying the fetched quote
- Automatic widget refresh at a defined interval
- Clean layered architecture on the backend (Controller → Service → Repository)

---

## 5. How to launch ?

### Backend — `citations-api`

**Prerequisites:** Java 17+, Maven, Docker

```bash
cd citations-api

# Start the PostgreSQL database
docker-compose up -d

# Run the Spring Boot API
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

### Frontend — `widCitations`

**Prerequisites:** Android Studio, Android SDK

1. Open the `widCitations` folder in **Android Studio**
2. Update the API base URL in the source if needed (e.g. use your machine's local IP if testing on a physical device)
3. Run the app on an emulator or a physical device
4. Add the widget to your home screen

---

<!-- ## 6. Preview

| Android Widget | API Response |
|:-:|:-:|
| *(screenshot coming soon)* | *(screenshot coming soon)* | -->

---

# widgetCitations

## Table des matières
1. [Introduction](#1-introduction)
2. [Technologies utilisées](#2-technologies-utilisées)
3. [Architecture](#3-architecture)
4. [Liste des fonctionnalités](#4-liste-des-fonctionnalités)
5. [Comment lancer le projet ?](#5-comment-lancer-le-projet-)
<!-- 6. [Aperçu](#6-aperçu) -->

---

## 1. Introduction

**widgetCitations** est un projet full-stack Android composé de deux modules :

- **`citations-api`** — une API REST Spring Boot qui sert des citations aléatoires stockées dans une base de données PostgreSQL
- **`widCitations`** — un widget Android affiché sur l'écran d'accueil, qui récupère et affiche une citation depuis l'API

---

## 2. Technologies utilisées

**Backend (`citations-api`)**
- **Java** — langage principal
- **Spring Boot** — framework REST API
- **Spring Data JPA** — accès à la base de données
- **PostgreSQL** — stockage des citations
- **Docker / Docker Compose** — base de données conteneurisée

**Frontend (`widCitations`)**
- **Java** — développement Android
- **Android SDK** — système de widget (`AppWidgetProvider`)
- **Client HTTP** — appels à l'API depuis le widget

---

## 3. Architecture

```
widgetCitations/
├── citations-api/        # API REST Spring Boot
│   └── ...               # Controllers, Services, Repositories, Entités
└── widCitations/         # Application Android
    └── ...               # Widget provider, layout, manifest
```

Le widget Android interroge l'API REST à intervalle régulier pour récupérer une citation aléatoire et l'afficher sur l'écran d'accueil.

---

## 4. Liste des fonctionnalités

- Endpoint REST renvoyant une citation aléatoire depuis la base de données
- Base de données PostgreSQL gérée via Docker
- Widget Android affichant la citation récupérée sur l'écran d'accueil
- Rafraîchissement automatique du widget à intervalle défini
- Architecture en couches propre côté backend (Controller → Service → Repository)

---

## 5. Comment lancer le projet ?

### Backend — `citations-api`

**Prérequis :** Java 17+, Maven, Docker

```bash
cd citations-api

# Démarrer la base de données PostgreSQL
docker-compose up -d

# Lancer l'API Spring Boot
./mvnw spring-boot:run
```

L'API sera disponible à l'adresse `http://localhost:8080`.

### Frontend — `widCitations`

**Prérequis :** Android Studio, Android SDK

1. Ouvrir le dossier `widCitations` dans **Android Studio**
2. Mettre à jour l'URL de base de l'API si nécessaire (utiliser l'IP locale de la machine pour un test sur appareil physique)
3. Lancer l'application sur un émulateur ou un appareil physique
4. Ajouter le widget sur l'écran d'accueil

---

<!-- ## 6. Aperçu

| Widget Android | Réponse de l'API |
|:-:|:-:|
| *(screenshot à venir)* | *(screenshot à venir)* | -->