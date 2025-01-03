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

## Création du Projet Maven
1. Ouvrez un terminal dans VS Code.
2. Tapez la commande suivante pour créer un projet Maven : 
```xml
    mvn archetype:generate -DgroupId=com.example -DartifactId=TP_JPA_Hibernate -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
3. Ouvrez le dossier du projet dans VS Code avec:
```xml
    code TP_JPA_Hibernate
```

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
```
Ajoutez les dépendances nécessaires dans le fichier pom.xml (voir l'étape correspondante dans ma réponse précédente).
- Pour mettre à jour les dépendances Maven, utilisez la commande :
```xml
mvn clean install
```

## Configuration de la Base de Données et Hibernate

- Créez un répertoire src/main/resources/META-INF et ajoutez le fichier persistence.xml.
```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.1">
    <persistence-unit name="tp_jpa_unit">
        <class>OneToOne.Personne</class>
        <class>OneToOne.Professeur</class>
        <class>OneToMany.Departement</class>
        <class>OneToMany.Adresse</class>
        <class>ManyToMany.Etudiant</class>
        <class>ManyToMany.Module</class>
        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hibernate_tp" />
            <property name="javax.persistence.jdbc.user" value="root" />
            <property name="javax.persistence.jdbc.password" value="password" />
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect" />
            <property name="hibernate.hbm2ddl.auto" value="update" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" />
        </properties>
    </persistence-unit>
</persistence>
```
- Assurez-vous que votre base de données MySQL est active et accessible.