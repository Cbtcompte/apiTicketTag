package jpa.models.abstracts;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jpa.utils.Formatter;

@MappedSuperclass
public class GenerateCommonColumn implements Serializable {
    
    private Long id;
    private Date created_at = Date.from(Instant.now());
    private Date updated_at = Date.from(Instant.now());
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }
    
    @Column(name = "updated_at", nullable = false)
    public Date getUpdated_at() {
        return this.updated_at;
    }
    
    @Column(name = "created_at", nullable = false)
    public Date getCreated_at() {
        return this.created_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
