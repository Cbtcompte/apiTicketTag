package jpa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "equipes")
public class Equipes extends GenerateCommonColumn {
    
    private String name;
    private List<Utilisateurs> utilisateurs = new ArrayList<>();
    private List<Projects> projects = new ArrayList<>();

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.PERSIST)
    public List<Projects> getProjects() {
        return this.projects;
    }
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }
    
    @OneToMany(mappedBy = "equipe", cascade = CascadeType.PERSIST)
    public List<Utilisateurs> getUtilisateurs() {
        return this.utilisateurs;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setUtilisateurs(List<Utilisateurs> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }
}
