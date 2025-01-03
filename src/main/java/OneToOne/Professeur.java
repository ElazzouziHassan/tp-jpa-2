package OneToOne;
import javax.persistence.*;

@Entity // Annotation pour indiquer que cette classe est une entité persistante JPA
@Table(name = "professeurs") // Spécifie le nom de la table dans la base de données
public class Professeur {
  @Id  // Indique que le champ suivant est la clé primaire
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String specialite; // Attribut pour stocker la spécialité du professeur

  // Mapping @OneToOne pour la relation un-à-un avec l'entité Personne
  // @JoinColumn spécifie que la colonne "personne_id" sera utilisée comme clé étrangère dans la table "professeurs"
  @OneToOne 
  @JoinColumn(name = "personne_id") // Spécifie le nom de la colonne de clé étrangère dans la table "professeurs"
  private Personne personne; // Un professeur est associé à une personne

  // Getters et Setters pour accéder et modifier les attributs
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getSpecialite() { return specialite; }
  public void setSpecialite(String specialite) { this.specialite = specialite; }
  public Personne getPersonne() { return personne; }
  public void setPersonne(Personne personne) { this.personne = personne; }

}
