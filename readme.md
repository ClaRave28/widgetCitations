# Technologies
- Java
- Android Studio
- Groovy DSL

## Structure
c'est dans le package main qu'on doit mettre ses fichiers
- `NewAppWidget.java` : logique du widget
- `new_app_widget.xml` : design du widget
- `new_app_widget_info.xml` : configuration du widget

## Lancer le projet
1. Ouvrir avec Android Studio
2. Lancer l'émulateur
3. Appui long sur l'écran d'accueil > Widgets

## Ordre de code de fichiers

new_app_widget_info.xml  (config)
↓
new_app_widget.xml       (design)
↓
NewAppWidget.java        (logique)

## Docker

docker run -p 8081:8080 --add-host=host.docker.internal:host-gateway adminer

puis pour lancer projet adminer

docker start adminer
docker stop adminer

## admirer

system : PostgreSQL
Serveur : host.docker.internal
Utilisateur : postgres
Mot de passe : postgres
Base de données : citations_db

Vérifier qu'il tourne : net start postgresql-x64-18


