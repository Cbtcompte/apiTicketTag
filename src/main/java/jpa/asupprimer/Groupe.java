package jpa.asupprimer;

import java.util.List;

import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jpa.models.Collaborateur;
// import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

// @Entity
// @Table(name = "groupes")
public class Groupe extends GenerateCommonColumn{
    
    private String name;
    private List<Collaborateur> equipes;


    public Groupe(String name) {
        this.name = name;
    }

    public Groupe() {}

    @OneToMany(mappedBy = "groupe")
    public  List<Collaborateur> getEquipes() {
        return this.equipes;
    }


    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setEquipes(List<Collaborateur> equipes) {
        this.equipes = equipes;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", name => "+this.getName()+"}";
    }
}
