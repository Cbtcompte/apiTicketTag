package jpa.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "projets")
public class Projet extends GenerateCommonColumn {
    private String theme;
    private String description;
    private Date startProjet;
    private Date endProjet;
    private Date startReelProjet;
    private Date endReelProjet;
    private List<Collaborateur> equipes;
    private List<Liste> listes;


    @OneToMany(mappedBy = "projet")
    public List<Liste> getListes() {
        return this.listes;
    }

    public void setListes(List<Liste> listes) {
        this.listes = listes;
    }

    @OneToMany(mappedBy = "projet")
    public  List<Collaborateur> getEquipes() {
        return this.equipes;
    }

    public void setEquipes(List<Collaborateur> equipes) {
        this.equipes = equipes;
    }    

    @Column(name = "theme", nullable = false)
    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "startProjet", nullable = false)
    public Date getStartProjet() {
        return this.startProjet;
    }

    public void setStartProjet(Date startProjet) {
        this.startProjet = startProjet;
    }

    @Column(name = "endProjet", nullable = false)
    public Date getEndProjet() {
        return this.endProjet;
    }

    public void setEndProjet(Date endProjet) {
        this.endProjet = endProjet;
    }

    @Column(name = "startReelProjet", nullable = true)
    public Date getStartReelProjet() {
        return this.startReelProjet;
    }

    public void setStartReelProjet(Date startReelProjet) {
        this.startReelProjet = startReelProjet;
    }

    @Column(name = "endReelProjet", nullable =  true)
    public Date getEndReelProjet() {
        return this.endReelProjet;
    }

    public void setEndReelProjet(Date endReelProjet) {
        this.endReelProjet = endReelProjet;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", theme => "+this.getTheme()+
                ", description => "+this.getDescription()+
                ", startProjet => "+this.getStartProjet()+
                ", endProjet => "+this.getEndProjet()+
                ", startReelProjet => "+this.getStartReelProjet()+
                ", endReelProjet =>"+this.getEndReelProjet()+"}";
    }

}
