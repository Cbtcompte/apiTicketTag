package jpa.models.associativeTables;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jpa.models.Ticket;
import jpa.models.Tag;
import jpa.models.associativesKey.TagTicketKey;

@Entity
@Table(name = "tag_tickets")
public class TagTickets {
    
    private TagTicketKey id;
    private Tag tag;
    private Ticket ticket;
    private Date created_at;
    private Date updated_at;

    @EmbeddedId
    public TagTicketKey getId() {
        return id;
    }

    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id")
    public Ticket getTicket() {
        return ticket;
    }
    
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tags_id")
    public Tag getTag() {
        return tag;
    }

    @Column(name = "updated_at", nullable = true)
    public Date getUpdated_at() {
        return this.updated_at;
    }
    
    @Column(name = "created_at", nullable = true)
    public Date getCreated_at() {
        return this.created_at;
    }


    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setId(TagTicketKey id) {
        this.id = id;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}
