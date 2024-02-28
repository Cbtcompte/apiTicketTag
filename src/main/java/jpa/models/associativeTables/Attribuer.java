package jpa.models.associativeTables;

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

@Entity
@Table(name = "assignees")
public class Attribuer {
    private TicketCollaborateurKey id;
    private Collaborateur collaborateur;
    private Ticket ticket;
    private String message;
    private Instant created_at;
    private Instant updated_at;

    @EmbeddedId
    public TicketCollaborateurKey getId() {
        return id;
    }

    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    @ManyToOne
    @MapsId("collaborateurId")
    @JoinColumn(name = "collaborateur_id")
    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id")
    public Ticket getTicket() {
        return ticket;
    }

    @Column(name = "updated_at", nullable = true)
    public Instant getUpdated_at() {
        return this.updated_at;
    }
    
    @Column(name = "created_at", nullable = true)
    public Instant getCreated_at() {
        return this.created_at;
    }


    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public void setId(TicketCollaborateurKey id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
}
