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
import jpa.models.Tags;
import jpa.models.associativesKey.TagsTicketKey;

@Entity
@Table(name = "tag_tickets")
public class TagTickets {
    
    private TagsTicketKey id;
    private Tags tag;
    private Tickets ticket;
    private Instant created_at;
    private Instant updated_at;

    @EmbeddedId
    public TagsTicketKey getId() {
        return id;
    }
    
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    public Tags getTag() {
        return tag;
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


    public void setTag(Tags tag) {
        this.tag = tag;
    }

    public void setId(TagsTicketKey id) {
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
