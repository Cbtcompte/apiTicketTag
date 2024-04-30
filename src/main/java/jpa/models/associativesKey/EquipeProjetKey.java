package jpa.models.associativesKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class EquipeProjetKey {

    private Long equipeId;
    private Long projetId;

    @Column(name = "equipe_id", nullable = false)
    public Long getUtilisateurId() {
        return equipeId;
    }

    @Column(name = "projet_id", nullable = false)
    public Long getProjetId() {
        return projetId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }

    public void setProjetId(Long projetId) {
        this.projetId = projetId;
    }
}
