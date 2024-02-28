package jpa.asupprimer;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jpa.models.Collaborateur;
import jpa.models.Ticket;
import jpa.models.associativesKey.TicketCollaborateurKey;

// @Entity
// @Table(name = "commentaires")
public class Commentaire {

    private TicketCollaborateurKey id;
    private Collaborateur collaborateur;
    private String message;
    private Ticket ticket;
    private Instant created_at;
    private Instant updated_at;


    @EmbeddedId
    public TicketCollaborateurKey getId() {
        return this.id;
    }

    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id")
    public Ticket getTicket() {
        return ticket;
    }

    @ManyToOne
    @MapsId("collaborateurId")
    @JoinColumn(name = "collaborateur_id")
    public Collaborateur getCollaborateur() {
        return this.collaborateur;
    }

    @Column(name = "updated_at", nullable = true)
    public Instant getUpdated_at() {
        return this.updated_at;
    }
    
    @Column(name = "created_at", nullable = true)
    public Instant getCreated_at() {
        return this.created_at;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public void setTicket(Ticket tickets) {
        this.ticket = tickets;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public void setId(TicketCollaborateurKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", commentaire => "+this.getMessage()+
                ", utilisateur => "+this.getCollaborateur().toString()+
                ", ticket => "+this.getTicket().toString()+"}";
    }
}
