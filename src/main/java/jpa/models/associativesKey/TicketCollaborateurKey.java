package jpa.models.associativesKey;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TicketCollaborateurKey implements Serializable {
    
    private Long collaborateurId;
    private Long ticketId;

    @Column(name = "ticket_id", nullable = false)
    public Long getTicketId() {
        return ticketId;
    }

    @Column(name = "collaborateur_id", nullable = false)
    public Long getCollaborateurId() {
        return collaborateurId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setCollaborateurId(Long collaborateurId) {
        this.collaborateurId = collaborateurId;
    }
}
