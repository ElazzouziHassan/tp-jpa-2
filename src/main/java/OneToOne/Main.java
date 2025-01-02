package OneToOne;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    // Affichage du message indiquant le début de l'exécution du mapping @OneToOne
    System.out.println("Exécution du mapping @OneToOne...");

    // Création de l'EntityManagerFactory, qui est responsable de la création de l'EntityManager
    // "tp_jpa_unit" correspond à l'unité de persistance définie dans le fichier persistence.xml
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_jpa_unit");
    
    // Création de l'EntityManager qui gère les opérations sur la base de données
    EntityManager em = emf.createEntityManager();

    // Démarre une transaction, ce qui signifie que toutes les modifications suivantes seront traitées
    // dans une seule unité de travail.
    em.getTransaction().begin();

    // Création d'une instance de la classe Personne et initialisation de ses propriétés
    Personne personne = new Personne();
    personne.setNom("El azzouzi Hassan");

    // Création d'une instance de la classe Professeur et initialisation de ses propriétés
    Professeur professeur = new Professeur();
    professeur.setSpecialite("Architecture Distribuées & Design Patterns");

    // Associer la personne au professeur et vice versa pour créer une relation bidirectionnelle
    professeur.setPersonne(personne); // Le professeur est associé à la personne
    personne.setProfesseur(professeur); // La personne est associée au professeur

    // Persister la personne, ce qui va aussi persister le professeur grâce à la cascade
    em.persist(personne);

    // Commit de la transaction, ce qui signifie que les modifications seront validées dans la base de données
    em.getTransaction().commit();

    // Affichage d'un message indiquant la réussite de l'exécution du mapping OneToOne
    System.out.println("OneToOne mapping executed successfully!");
    
    // Fermeture de l'EntityManager et de l'EntityManagerFactory après l'exécution des opérations
    em.close();
    emf.close();
  }
}
