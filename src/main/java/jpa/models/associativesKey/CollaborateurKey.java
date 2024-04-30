package jpa.models.associativesKey;

import jakarta.persistence.Column;

public class CollaborateurKey {
    private Long utilisateurId;
    private Long equipeProjetId;

    @Column(name = "utilisateur_id", nullable = false)
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    @Column(name = "equipeProjet_id", nullable = false)
    public Long getEquipeProjetId() {
        return equipeProjetId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setEquipeProjetId(Long equipeProjetId) {
        this.equipeProjetId = equipeProjetId;
    }
}
