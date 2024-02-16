package jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.Assignees;

@Entity
@Table(name="utilisateurs")
public class Utilisateurs extends GenerateCommonColumn {

    private String name;
    private String email;
    private Equipes equipe;
    private List<Assignees> assignees;
    private List<Comments> comments;
    
    
    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }
    
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }
    
    @ManyToOne
    @JoinColumn(name = "equipe_id", nullable =  false)
    public Equipes getEquipe() {
        return this.equipe;
    }


    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
    public List<Assignees> getAssignees() {
        return assignees;
    }


    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
    public List<Comments> getComments() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEquipe(Equipes equipe) {
        this.equipe = equipe;
    }

    public void setAssignees(List<Assignees> assignees) {
        this.assignees = assignees;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", name => "+this.getName()+
                ", email => "+this.getEmail()+
                ", equipe => "+this.getEquipe()+"}";

    }
}
