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

    private Long utilisateurId;
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

    @Column(name = "utilisateur_id", nullable = false)
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setTicket(Tickets tickets) {
        this.ticket = tickets;
    }
}
