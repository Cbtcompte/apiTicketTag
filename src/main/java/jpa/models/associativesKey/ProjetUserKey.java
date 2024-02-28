package jpa.models.associativesKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProjetUserKey {

    private Long utilisateurId;
    private Long projetId;

    @Column(name = "utilisateur_id", nullable = false)
    public Long getUtilisateurId() {
        return utilisateurId;
    }

    @Column(name = "projet_id", nullable = false)
    public Long getProjetId() {
        return projetId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }
}
