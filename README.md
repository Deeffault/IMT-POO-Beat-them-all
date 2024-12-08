# Beat Them All - Jeu en Console

Ce projet implémente un jeu de type **"Beat Them All"** en console. Le joueur incarne un héros qui avance sur un
parcours, rencontre divers ennemis, et tente de les vaincre pour atteindre la ligne d'arrivée.

## 🛠️🛠 Prérequis

- **JDK** Amazon Corretto 22 (ou supérieur)

## Installation et Exécution

1. Cloner le dépôt :
   ```bash
   git clone <lien-du-dépôt>
    cd IMT-POO-Beat-them-all
    ```

## 📚 Description du Jeu

- **Objectif** : Avancer sur un parcours, vaincre les ennemis rencontrés et atteindre la fin sans être mis K.O.
- **Personnages** :
    - Le joueur contrôle un héros avec des caractéristiques uniques (points de vie, force d'attaque, défense, capacité
      spéciale).
    - Plusieurs types d'ennemis : brigands, catcheurs, gangsters, et plus encore.
- **Cartes** :
    - Chaque carte possède un lieu, un nom, un début, une fin et une longueur de parcours.
- **Combat** :
    - Le héros attaque en premier sauf face aux gangsters.
    - Les combats incluent des capacités spéciales utilisables une seule fois par niveau.

## 🛠️ Fonctionnalités Implémentées

### Classe Principale `Main`

La classe `Main` gère le flux principal du jeu, notamment:

- **Choix du héros** : Trois options avec des capacités et statistiques uniques:
    1. **Artur Pendragon** : Points de vie élevés avec capacité spéciale de soin.
    2. **Lancelot** : Stratégiste avec capacité de stun (attaques nulles pour l'ennemi en train de combatre).
    3. **Genièvre** : Force brute avec capacité de one-shot (tue un ennemi en un coup).
- **Choix de la carte** : Deux options:
    - **Château Caermaloyw** : Une carte longue avec 7 zones.
    - **Taverne du Chat Noir** : Une carte plus courte avec 4 zones.
- **Progression dans le jeu**:
    - Déplacement automatique du héros d'une zone à une autre après avoir vaincu tous les ennemis.
    - Gestion de la fin de partie: victoire (atteinte de la fin de la carte) ou défaite (mort du héros).

### Structure et Héritage

- **Interface `Character`** : Définit les comportements communs à tous les personnages.
- **Classes `Hero`, `Enemy`, et leurs sous-classes**:
    - `Hero` : Personnage contrôlé par le joueur, avec des capacités spéciales (`HEALING`, `RAGE`, `ONE_SHOT`, `NONE`).
    - `Enemy`, `Brigand`, `Gangster`, `Wrestler` : Ennemis avec des comportements spécifiques.

### Gestion des Zones et Cartes

- **Classe `Area`** :
    - Génère un nombre aléatoire d'ennemis (1 à 4) avec des types variés.
    - Stocke les ennemis dans une zone.
- **Classe `Map`** :
    - Représente une carte du jeu avec plusieurs zones.
    - Gère la position actuelle du joueur et permet de se déplacer à travers les zones.

### Système de Combat

- **Classe `Fight`** :
    - Gère la logique des combats entre le héros et les ennemis.
    - Permet au héros d'attaquer plusieurs fois, d'utiliser sa capacité spéciale, et prend en compte les
      caractéristiques spécifiques des ennemis (comme les attaques à distance des gangsters).

### Gestion des Entrées Utilisateur

- **Classe `InputHandler`** :
    - Gère les entrées utilisateur pour les choix et les interactions pendant le jeu.

### Journaux

- Utilisation de **Log4j** pour tracer les actions importantes dans un fichier de log :
    - Exemple : "Le héros avance", "L'ennemi attaque le héros, ses PV sont maintenant ...".

### Tests Unitaires

- Test 1 : Simulation d'une attaque d'un héros sur un ennemi (PV de l'ennemi réduits à 0, il disparaît).
- Test 2 : Simulation de la défaite du héros avant la ligne d'arrivée (fin de partie avec défaite).
- Test 3 : Simulation de l'utilisation de la capacité spéciale du héros.
- Test 4 : Vérification que le nombre d'attaques du héros est bien entre 1 et 5.
- Tests supplémentaires pour les fonctionnalités importantes.

## 📄 Architecture du Projet

```
src/ 
└── org/example/ 
├── Main.java # Classe principale du programme 
├── characters/ 
│ 
├── Character.java # Interface définissant les comportements des personnages 
│ ├── Hero.java # Classe représentant le héros 
│ ├── Enemy.java # Classe de base pour les ennemis 
│ ├── Brigand.java # Classe représentant un brigand 
│ ├── Gangster.java # Classe représentant un gangster 
│ ├── Wrestler.java # Classe représentant un catcheur 
│ └── SpecialCapacity.java # Enum pour les capacités spéciales 
├── utils/ 
│ ├── Area.java # Classe gérant les zones et les ennemis 
│ ├── Map.java # Classe représentant les cartes du jeu 
│ ├── Fight.java # Classe gérant les combats 
│ └── InputHandler.java # Classe gérant les entrées utilisateur
```

## 📌 Auteurs

Ce projet a été réalisé par:

- [William Pereira](https://github.com/pereirawilliam)
- [Théo Lebiez](https://github.com/Deeffault)
