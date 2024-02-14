package jpa.models.abstracts;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class GenerateCommonColumn implements Serializable {
    
    private Long id;
    private Instant created_at = Instant.now();
    private Instant updated_at = Instant.now();
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }
    
    @Column(name = "updated_at", nullable = false)
    public Instant getUpdated_at() {
        return this.updated_at;
    }
    
    @Column(name = "created_at", nullable = false)
    public Instant getCreated_at() {
        return this.created_at;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }
}
