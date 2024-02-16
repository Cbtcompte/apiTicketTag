package jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "comments")
public class Comments extends GenerateCommonColumn{

    private Utilisateurs utilisateur;
    private String comment;
    private Tickets ticket;

    @Column(name = "comment", nullable = false)
    public String getComment() {
        return comment;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    public Tickets getTicket() {
        return ticket;
    }

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setTicket(Tickets tickets) {
        this.ticket = tickets;
    }
}
