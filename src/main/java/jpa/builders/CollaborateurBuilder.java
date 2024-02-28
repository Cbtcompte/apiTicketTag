package jpa.builders;

import jpa.dtos.CollaborateurDto;
import jpa.models.Collaborateur;
import jpa.models.Projet;
import jpa.models.Utilisateur;

public class CollaborateurBuilder {
    private String name;
    private Utilisateur utilisateur;
    private Projet projet;

    public CollaborateurBuilder setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

        return this;
    }

    public CollaborateurBuilder setProjet(Projet projet) {
        this.projet = projet;

        return this;
    }

    public CollaborateurBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public Collaborateur build(){
        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setName(this.name);
        collaborateur.setProjet(this.projet);
        collaborateur.setUtilisateur(this.utilisateur);
        return collaborateur;
    }
    
    public CollaborateurDto builDto(){
        CollaborateurDto collaborateurDto = new CollaborateurDto();
        collaborateurDto.setName(this.name);
        collaborateurDto.setProjet(this.projet);
        collaborateurDto.setUtilisateur(this.utilisateur);
        return collaborateurDto;
    }
}
