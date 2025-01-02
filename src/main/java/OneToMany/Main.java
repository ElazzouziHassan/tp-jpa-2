package OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    
    // Affichage dans la console pour indiquer le début de l'exécution du mapping OneToMany et ManyToOne.
    System.out.println("Exécution du mapping @OneToMany et @ManyToOne...");

     // Création de l'EntityManagerFactory en utilisant l'unité de persistance définie dans le fichier persistence.xml (nommé ici "tp_jpa_unit").
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_jpa_unit");
    // Création de l'EntityManager à partir de l'EntityManagerFactory. Cela gère les entités et les transactions.
    EntityManager em = emf.createEntityManager();

    // Démarrage d'une transaction. Toutes les opérations suivantes seront incluses dans cette transaction.
    em.getTransaction().begin();

    // Création d'un objet Departement et définition de son nom.
    Departement dep = new Departement();
    dep.setNom("Informatique");

    // Création de deux objets Adresse avec des informations spécifiques sur chaque adresse.
    Adresse add1 = new Adresse();
    add1.setRue("123 Rue Principale");
    // Association de la première adresse au département Informatique.
    add1.setDepartement(dep);

    Adresse add2 = new Adresse();
    add2.setRue("456 Rue Secondaire");
    // Association de la deuxième adresse au même département Informatique.
    add2.setDepartement(dep);

    // Ajout des adresses à la liste des adresses du département.
    dep.getAdresses().add(add1);
    dep.getAdresses().add(add2);

    // Persistance de l'objet Departement. Cela persiste également les objets Adresse car la relation est en cascade.
    em.persist(dep);

    // Validation de la transaction. Toutes les modifications effectuées dans la transaction sont enregistrées dans la base de données.
    em.getTransaction().commit();

    // Affichage dans la console pour indiquer que les mappings OneToMany et ManyToOne ont été exécutés avec succès.
    System.out.println("OneToMany and ManyToOne mapping executed successfully!");
    
    // Fermeture de l'EntityManager pour libérer les ressources.
    em.close();
    // Fermeture de l'EntityManagerFactory pour libérer les ressources.
    emf.close();
  }
}
