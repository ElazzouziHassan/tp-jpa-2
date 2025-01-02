# TP JPA et Hibernate - Mapping Relationnel

Ce TP implémente plusieurs types de relations entre entités JPA à l'aide de Hibernate pour la gestion des bases de données. Il présente des exemples de relations `OneToOne`, `OneToMany`, et `ManyToMany` à travers plusieurs entités, notamment `Personne`, `Professeur`, `Etudiant`, `Module`, `Departement`, et `Adresse`.

## Structure du Projet

### Entités

- **`Personne`** : Entité représentant une personne. Elle est liée à un professeur dans une relation `OneToOne`.
- **`Professeur`** : Entité représentant un professeur. Elle est liée à une personne dans une relation `OneToOne`.
- **`Etudiant`** : Entité représentant un étudiant. Elle est liée à plusieurs modules dans une relation `ManyToMany`.
- **`Module`** : Entité représentant un module. Il est lié à plusieurs étudiants dans une relation `ManyToMany`.
- **`Departement`** : Entité représentant un département. Il peut avoir plusieurs adresses dans une relation `OneToMany`.
- **`Adresse`** : Entité représentant une adresse. Elle est liée à un département dans une relation `ManyToOne`.

### Relations entre Entités

- **`OneToOne`** : La relation entre `Personne` et `Professeur` est un exemple de relation `OneToOne`. Une personne a un professeur, et un professeur est associé à une seule personne.
- **`OneToMany`** : La relation entre `Departement` et `Adresse` est un exemple de relation `OneToMany`. Un département peut avoir plusieurs adresses.
- **`ManyToMany`** : La relation entre `Etudiant` et `Module` est un exemple de relation `ManyToMany`. Un étudiant peut suivre plusieurs modules, et un module peut avoir plusieurs étudiants inscrits.

## Fonctionnement du Code

### 1. **`Personne` et `Professeur` (OneToOne)**
- Dans cette relation, chaque personne a un professeur et chaque professeur est associé à une personne.
- La persistance des entités est gérée avec `EntityManager` de JPA.

### 2. **`Departement` et `Adresse` (OneToMany et ManyToOne)**
- Un département peut avoir plusieurs adresses associées, mais chaque adresse est liée à un seul département.
- Cette relation est réalisée à l'aide des annotations `@OneToMany` et `@ManyToOne`.

### 3. **`Etudiant` et `Module` (ManyToMany)**
- Un étudiant peut suivre plusieurs modules, et un module peut avoir plusieurs étudiants inscrits.
- La relation est gérée avec l'annotation `@ManyToMany` et une table d'association `etudiant_module`.

## Prérequis

- **JDK 17** ou supérieur.
- **Maven** pour la gestion des dépendances et la compilation du projet.
- **MySQL** pour la base de données, avec la configuration appropriée dans le fichier `persistence.xml`.

## Dépendances Maven

Le projet utilise les dépendances suivantes :

- **Hibernate** : pour la gestion des entités et des transactions.
- **MySQL Connector** : pour la connexion à la base de données MySQL.
- **JPA API** : pour la gestion des entités via l'API JPA.

## Fichier `pom.xml`

Le fichier `pom.xml` inclut les dépendances pour Hibernate, MySQL, et JPA. Voici les dépendances importantes :

```xml
<dependencies>
    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.15.Final</version>
    </dependency>
    <!-- MySQL Connector -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.33</version>
    </dependency>
    <!-- JPA API -->
    <dependency>
        <groupId>javax.persistence</groupId>
        <artifactId>javax.persistence-api</artifactId>
        <version>2.2</version>
    </dependency>
</dependencies>
