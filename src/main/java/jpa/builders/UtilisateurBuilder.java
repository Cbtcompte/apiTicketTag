package jpa.builders;

import jpa.models.Utilisateur;

public class UtilisateurBuilder {
    private String name;
    private String email;


    public UtilisateurBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UtilisateurBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Utilisateur build(){
        Utilisateur utilisateurs = new Utilisateur();
        utilisateurs.setEmail(this.email);
        utilisateurs.setName(this.name);

        return utilisateurs;
    }
}
