package jpa.models.associativesKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TicketUtilisateurKey implements Serializable {
    
    private Long ticketId;

    private Long utilisateurId;

    @Column(name = "ticket_id", nullable = false)
    public Long getTicketId() {
        return ticketId;
    }

    @Column(name = "utilisateur_id", nullable = false)
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
