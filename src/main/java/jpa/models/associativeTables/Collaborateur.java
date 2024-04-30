package jpa.models.associativeTables;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.Utilisateur;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "collaborateurs")
public class Collaborateur extends GenerateCommonColumn{

    private String name;
    private Utilisateur utilisateur;
    private EquipeProjet equipeProjet;
    private List<Attribuer> assignees;


    @ManyToOne
    @MapsId("equipeProjetId")
    @JoinColumn(name = "equipeProjet_id")    
    public EquipeProjet getEquipeProjet() {
        return this.equipeProjet;
    }
    
    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id")    
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    
    @OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
    public List<Attribuer> getAssignees() {
        return assignees;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setUtilisateurs(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setEquipeProjet(EquipeProjet equipeProjet) {
        this.equipeProjet = equipeProjet;
    }
   
    public void setAssignees(List<Attribuer> assignees) {
        this.assignees = assignees;
    }
}
