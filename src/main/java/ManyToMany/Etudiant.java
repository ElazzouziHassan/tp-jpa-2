package ManyToMany;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // L'annotation @Entity indique que cette classe représente une entité JPA qui sera mappée à une table dans la base de données.
public class Etudiant {
  @Id // L'annotation @Id marque l'attribut suivant comme la clé primaire de l'entité.
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // L'ID de l'étudiant.
  private String nom; // Le nom de l'étudiant.

  // La relation Many-to-Many entre l'entité Etudiant et Module.
  @ManyToMany // L'annotation @ManyToMany spécifie une relation "plusieurs à plusieurs".
  // L'annotation @JoinTable définit la table de jointure qui représente la relation Many-to-Many.
  @JoinTable( 
    // Le nom de la table de jointure.
    name = "etudiant_module", 
    // La colonne de clé étrangère dans la table de jointure qui fait référence à l'entité Etudiant.
    joinColumns = @JoinColumn(name = "etudiant_id"), 
    // La colonne de clé étrangère dans la table de jointure qui fait référence à l'entité Module.
    inverseJoinColumns = @JoinColumn(name = "module_id")  
  )
  private List<Module> modules = new ArrayList<>();  // Liste des modules auxquels un étudiant est inscrit.

  // Getters et setters pour les attributs de l'entité Etudiant.
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNom() { return nom; }
  public void setNom(String nom) { this.nom = nom; }
  public List<Module> getModules() { return modules; }
  public void setModules(List<Module> modules) { this.modules = modules; }
}
