package jpa.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.EquipeProjet;

@Entity
@Table(name = "projets")
public class Projet extends GenerateCommonColumn {
    private String theme;
    private String description;
    private String status = "En cours";
    private Date startProjet;
    private Date endProjet;
    private List<EquipeProjet> equipeProjets;
    private List<Liste> listes;

    public void setEquipeProjets(List<EquipeProjet> equipeProjets) {
        this.equipeProjets = equipeProjets;
    }

    @OneToMany(mappedBy = "projet")
    public List<Liste> getListes() {
        return this.listes;
    }

    public void setListes(List<Liste> listes) {
        this.listes = listes;
    }

    @OneToMany(mappedBy = "projet")
    public  List<EquipeProjet> getEquipeProjets() {
        return this.equipeProjets;
    }
    
    @Column(name = "status", nullable = false)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", theme => "+this.getTheme()+
                ", description => "+this.getDescription()+
                ", startProjet => "+this.getStartProjet()+
                ", endProjet => "+this.getEndProjet()+"}";
    }

}
