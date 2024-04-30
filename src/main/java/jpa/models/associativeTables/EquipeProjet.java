package jpa.models.associativeTables;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.Equipe;
import jpa.models.Projet;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "equipe_projets")
public class EquipeProjet extends GenerateCommonColumn{

    private Equipe equipe;
    private Projet projet;
    private String comments;
    private Date startReelProjet;
    private Date endReelProjet;
    private List<Collaborateur> utilisateurCollaborateurs;

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @OneToMany(mappedBy = "equipeProjet")
    public List<Collaborateur> getUtilisateurCollaborateurs() {
        return this.utilisateurCollaborateurs;
    }

    public void setUtilisateurCollaborateurs(List<Collaborateur> utilisateurCollaborateurs) {
        this.utilisateurCollaborateurs = utilisateurCollaborateurs;
    }

    @Column(name = "comments", nullable = false)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    @ManyToOne
    @MapsId("projetId")
    @JoinColumn(name = "projet_id")
    public Projet getProjet() {
        return projet;
    }

    @ManyToOne
    @MapsId("equipeId")
    @JoinColumn(name = "equipe_id")
    public Equipe getEquipe() {
        return equipe;
    }

    @Column(name = "startReelProjet", nullable = true)
    public Date getStartReelProjet() {
        return this.startReelProjet;
    }

    public void setStartReelProjet(Date startReelProjet) {
        this.startReelProjet = startReelProjet;
    }

    @Column(name = "endReelProjet", nullable =  true)
    public Date getEndReelProjet() {
        return this.endReelProjet;
    }

    public void setEndReelProjet(Date endReelProjet) {
        this.endReelProjet = endReelProjet;
    }
}
