package jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "listes")
public class Liste extends GenerateCommonColumn {
    private String titre;
    private Projet projet;
    private List<Ticket> tickets; 


    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = true)
    public Projet getProjet() {
        return this.projet;
    }

    public void setListe(Projet projet) {
        this.projet = projet;
    }

    @Column(name = "titre", nullable = false)
    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    @OneToMany(mappedBy = "liste", cascade = CascadeType.PERSIST)
    public List<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    
    @Override
    public String toString() {
        return "{id => "+this.getId()+
                ", titre => "+this.getTitre()+"}";
    }

}
