package jpa.models.associativesKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class TagsTicketKey {
    
    private Long ticketId;
    private Long tagId;

    @Column(name = "ticket_id", nullable = false)
    public Long getTicketId() {
        return ticketId;
    }

    @Column(name = "tags_id", nullable = false)
    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}
