package OneToMany;
import javax.persistence.*;

@Entity // L'entité sera mappée à une table dans la base de données.
public class Adresse {
  @Id // Déclare cette propriété comme étant l'identifiant de l'entité.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // L'ID sera généré automatiquement (auto-incrémenté) par la base de données.
  private Long id; // L'ID de l'adresse.
  private String rue; // L'attribut représentant la rue de l'adresse.
  // Relation ManyToOne : Chaque adresse est associée à un seul département.
  @ManyToOne 
  @JoinColumn(name = "departement_id") // Spécifie la colonne dans la table Adresse qui fera référence à l'entité Departement.
  private Departement departement; // L'entité Departement associée à cette adresse.
  // Getter et Setter pour l'ID.
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  // Getter et Setter pour la rue de l'adresse.
  public String getRue() { return rue; }
  public void setRue(String rue) { this.rue = rue; }
  // Getter et Setter pour le département associé à l'adresse.
  public Departement getDepartement() { return departement; }
  public void setDepartement(Departement departement) { this.departement = departement; }
  
}
