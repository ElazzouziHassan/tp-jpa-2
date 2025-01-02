package ManyToMany;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    // Affichage dans la console pour indiquer le début de l'exécution du mapping ManyToMany.
    System.out.println("Exécution du mapping @ManyToMany...");
    
    // Création de l'EntityManagerFactory en utilisant l'unité de persistance définie dans le fichier persistence.xml (nommé ici "tp_jpa_unit").
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_jpa_unit");
    
    // Création de l'EntityManager à partir de l'EntityManagerFactory. Cela gère les entités et les transactions.
    EntityManager em = emf.createEntityManager();

    // Démarrage d'une transaction. Toutes les opérations suivantes seront incluses dans cette transaction.
    em.getTransaction().begin();

    // Création d'un nouvel objet Etudiant et définition de son nom.
    Etudiant etudiant = new Etudiant();
    etudiant.setNom("Hassan");

    // Création d'un nouvel objet Module et définition de son nom.
    Module module = new Module();
    module.setNom("Architecture Distribuées & Design Patterns");

    // Ajout du module à la liste des modules de l'étudiant.
    etudiant.getModules().add(module);
    // Ajout de l'étudiant à la liste des étudiants du module.
    module.getEtudiants().add(etudiant);

     // Persistance de l'objet Etudiant (ajout à la base de données).
    em.persist(etudiant);
    // Persistance de l'objet Module (ajout à la base de données).
    em.persist(module);

    // Validation de la transaction. Toutes les modifications effectuées dans la transaction sont enregistrées dans la base de données.
    em.getTransaction().commit();

    // Affichage dans la console pour indiquer que le mapping ManyToMany a été exécuté avec succès.
    System.out.println("ManyToMany mapping executed successfully!");
    
    // Fermeture de l'EntityManager pour libérer les ressources.
    em.close();
    // Fermeture de l'EntityManagerFactory pour libérer les ressources.
    emf.close();
  }
}
