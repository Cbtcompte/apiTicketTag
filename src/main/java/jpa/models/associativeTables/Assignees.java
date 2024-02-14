package jpa.models.associativeTables;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jpa.models.Tickets;
import jpa.models.Utilisateurs;
import jpa.models.associativesKey.TicketUtilisateurKey;

@Entity
@Table(name = "assignees")
public class Assignees {
    private TicketUtilisateurKey id;
    private Utilisateurs utilisateur;
    private Tickets ticket;
    private Instant created_at;
    private Instant updated_at;

    @EmbeddedId
    public TicketUtilisateurKey getId() {
        return id;
    }
    
    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id")
    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id")
    public Tickets getTicket() {
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


    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setId(TicketUtilisateurKey id) {
        this.id = id;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
}
