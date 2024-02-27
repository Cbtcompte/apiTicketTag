package jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name="utilisateurs")
public class Utilisateur extends GenerateCommonColumn {

    private String name;
    private String email;
    private List<Collaborateur> equipes;
    
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }
    
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }
    
    @OneToMany(mappedBy = "utilisateur")
    public  List<Collaborateur> getEquipes() {
        return this.equipes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEquipes(List<Collaborateur> equipes) {
        this.equipes = equipes;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", name => "+this.getName()+
                ", email => "+this.getEmail()+"}";

    }
}
