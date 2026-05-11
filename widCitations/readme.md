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