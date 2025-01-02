package OneToMany;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // Indique que la classe est une entité JPA et sera mappée à une table dans la base de données.
public class Departement {
  @Id // Déclare cette propriété comme étant l'identifiant de l'entité.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Spécifie que la valeur de l'ID sera générée automatiquement par la base de données (avec une stratégie d'auto-incrémentation).
  
  private Long id; // L'ID du département.
  private String nom; // Le nom du département.

  // Déclare une relation OneToMany entre Departement et Adresse, signifiant qu'un département peut avoir plusieurs adresses.
  @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL) 
  private List<Adresse> adresses = new ArrayList<>(); // Liste des adresses associées à ce département.

  // Getter et Setter pour l'ID.
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  // Getter et Setter pour le nom du département.
  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }
   // Getter et Setter pour la liste des adresses.
  public List<Adresse> getAdresses() { return adresses;}
  public void setAdresses(List<Adresse> adresses) { this.adresses = adresses;}

}
