package jpa.builders;

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
        Collaborateur equipes = new Collaborateur();
        equipes.setName(this.name);
        equipes.setProjet(this.projet);
        equipes.setUtilisateur(this.utilisateur);
        return equipes;
    }
}
