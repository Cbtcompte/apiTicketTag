package jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.Attribuer;

@Entity
@Table(name = "collaborateurs")
public class Collaborateur extends GenerateCommonColumn {
    
    private String name;
    private Utilisateur utilisateur;
    private Projet projet;
    private List<Attribuer> assignees;

    public Collaborateur() {}

    public Collaborateur(String name, Utilisateur utilisateur, Projet projet) {
        this.name = name;
        this.utilisateur = utilisateur;
        this.projet = projet;
    }

    
    @ManyToOne
    @MapsId("projetId")
    @JoinColumn(name = "projet_id")    
    public Projet getProjet() {
        return this.projet;
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

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
   
    public void setAssignees(List<Attribuer> assignees) {
        this.assignees = assignees;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", name => "+this.getName()+"}";
    }
}
