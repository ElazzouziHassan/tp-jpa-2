package ManyToMany;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity  // L'annotation @Entity marque cette classe comme une entité JPA, indiquant qu'elle sera mappée à une table de la base de données.
public class Module {
  @Id // L'annotation @Id définit l'attribut suivant comme étant la clé primaire de l'entité.
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Cette annotation permet de générer automatiquement l'ID via la base de données (généralement sous forme d'auto-incrément).
  private Long id; // L'ID du module.

  private String nom;  // Le nom du module.
  // La relation Many-to-Many avec l'entité Etudiant.
  @ManyToMany(mappedBy = "modules") // L'annotation @ManyToMany indique une relation Many-to-Many avec l'entité Etudiant. 'mappedBy' spécifie que l'attribut 'modules' dans l'entité Etudiant gère cette relation.
  private List<Etudiant> etudiants = new ArrayList<>(); // Liste des étudiants inscrits à ce module.

  // Getters et setters pour les attributs de l'entité Module.
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }
  public List<Etudiant> getEtudiants() { return etudiants;}
  public void setEtudiants(List<Etudiant> etudiants) { this.etudiants = etudiants;}

}
