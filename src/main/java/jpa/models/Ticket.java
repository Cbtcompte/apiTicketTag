package jpa.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.Attribuer;
import jpa.models.associativeTables.TagTickets;

@Entity
@Table(name = "tickets")
public class Ticket extends GenerateCommonColumn {

    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Instant dateStart;
    private Instant dateEnd;
    private Liste liste;
    private List<TagTickets> tagTickets;
    private List<Attribuer> assignees;

    @Column(name = "libelle", nullable = false)
    public String getLibelle() {
        return this.libelle;
    }
    
    @Column(name = "isClosed", nullable = false)
    public Boolean getIsClosed() {
        return this.isClosed;
    }
    
    @Column(name = "isForEveryOne", nullable = false)
    public Boolean getIsForEveryOne() {
        return this.isForEveryOne;
    }

    @Column(name = "dateStart", nullable = false)
    public Instant getDateStart() {
        return this.dateStart;
    }

    @Column(name = "dateEnd", nullable = false)
    public Instant getDateEnd() {
        return this.dateEnd;
    }

    @OneToMany(mappedBy = "ticket")
    public List<TagTickets> getTagTickets() {
        return this.tagTickets;
    }

    @OneToMany(mappedBy = "ticket")
    public List<Attribuer> getAssignees() {
        return assignees;
    }

    @ManyToOne
    @JoinColumn(name = "liste_id", nullable = false)
    public Liste getListe() {
        return this.liste;
    }

    public void setListe(Liste liste) {
        this.liste = liste;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }


    public void setIsForEveryOne(Boolean isForEveryOne) {
        this.isForEveryOne = isForEveryOne;
    }

    public void setDateStart(Instant dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Instant dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setTagTickets(List<TagTickets> tagTickets) {
        this.tagTickets = tagTickets;
    }

    public void setAssignees(List<Attribuer> assignees) {
        this.assignees = assignees;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", theme => "+this.getLibelle()+
                ", isClosed => "+this.getIsClosed()+
                ", isForEveryOne => "+this.getIsForEveryOne()+
                ", dateStart => "+this.getDateStart()+
                ", dateEnd => "+this.getDateEnd()+"}";
    }
}