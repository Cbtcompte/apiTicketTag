package jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.Collaborateur;

@Entity
@Table(name="utilisateurs")
public class Utilisateur extends GenerateCommonColumn {

    private String name;
    private String email;
    private List<Collaborateur> equipeCollaborateurs;
    
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }
    
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }
    
    @OneToMany(mappedBy = "utilisateur")
    public  List<Collaborateur> getequipeCollaborateurs() {
        return this.equipeCollaborateurs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEquipeCollaborateurs(List<Collaborateur> equipeCollaborateurs) {
        this.equipeCollaborateurs = equipeCollaborateurs;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", name => "+this.getName()+
                ", email => "+this.getEmail()+"}";

    }
}
