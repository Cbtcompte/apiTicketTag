package jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.TagTickets;

@Entity
@Table(name = "tags")
public class Tags extends GenerateCommonColumn {

    private String libelle;
    private String couleur;
    private List<TagTickets> tagTickets;

    @Column(name = "libelle", nullable = false)
    public String getLibelle() {
        return this.libelle;
    }

    @OneToMany(mappedBy = "tag", cascade = CascadeType.PERSIST)
    public List<TagTickets> getTagTickets() {
        return this.tagTickets;
    }

    @Column(name = "couleur", nullable = false)
    public String getCouleur() {
        return this.couleur;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    public void setTagTickets(List<TagTickets> tagTickets) {
        this.tagTickets = tagTickets;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", libelle => "+this.getLibelle()+
                ", couleur => "+this.getCouleur()+"}";
    }
}
