package OneToOne;
import javax.persistence.*;

@Entity // Annotation pour indiquer que cette classe est une entité persistante JPA
@Table(name = "personnes") // Annotation pour indiquer que cette classe est une entité persistante JPA
public class Personne {
  @Id // Indique que le champ suivant est la clé primaire
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nom; // Attribut pour stocker le nom de la personne

  // Mapping @OneToOne pour la relation un-à-un avec l'entité Professeur
  // "mappedBy" indique que la relation est gérée par l'attribut "personne" de la classe Professeur
  // La cascade CascadeType.ALL signifie que toutes les opérations (persist, merge, remove, etc.) sur Personne seront aussi appliquées à Professeur
  @OneToOne(mappedBy = "personne", cascade = CascadeType.ALL)
  private Professeur professeur;

  // Getters et Setters pour accéder et modifier les attributs
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }
  public Professeur getProfesseur() { return professeur; }
  public void setProfesseur(Professeur professeur) { this.professeur = professeur;}

}
