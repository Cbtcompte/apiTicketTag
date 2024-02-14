package jpa.models;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.Assignees;
import jpa.models.associativeTables.TagTickets;

@Entity
@Table(name = "tickets")
public class Tickets extends GenerateCommonColumn {

    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Instant dateStart;
    private Instant dateEnd;
    private List<TagTickets> tagTickets;
    private List<Assignees> assignees;
    private List<Comments> comments;


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

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.PERSIST)
    public List<Comments> getComments() {
        return comments;
    }

    @OneToMany(mappedBy = "ticket")
    public List<Assignees> getassignees() {
        return assignees;
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

    public void setassignees(List<Assignees> assignees) {
        this.assignees = assignees;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }
}
