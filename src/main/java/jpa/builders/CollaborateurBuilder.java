package jpa.builders;

import jpa.dtos.CollaborateurDto;
import jpa.models.Utilisateur;
import jpa.models.associativeTables.Collaborateur;
import jpa.models.associativeTables.EquipeProjet;

public class CollaborateurBuilder {
    private String name;
    private Utilisateur utilisateur;
    private EquipeProjet equipeProjet;

    public CollaborateurBuilder setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

        return this;
    }

    public CollaborateurBuilder setProjet(EquipeProjet equipeProjet) {
        this.equipeProjet = equipeProjet;

        return this;
    }

    public CollaborateurBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public Collaborateur build(){
        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setName(this.name);
        collaborateur.setEquipeProjet(this.equipeProjet);
        collaborateur.setUtilisateur(this.utilisateur);
        return collaborateur;
    }
    
    public CollaborateurDto builDto(){
        CollaborateurDto collaborateurDto = new CollaborateurDto();
        collaborateurDto.setName(this.name);
        collaborateurDto.setUtilisateur(this.utilisateur);
        return collaborateurDto;
    }
}
