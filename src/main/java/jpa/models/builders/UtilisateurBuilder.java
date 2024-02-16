package jpa.models.builders;

import jpa.models.Utilisateurs;

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

    public Utilisateurs build(){
        Utilisateurs utilisateurs = new Utilisateurs();
        utilisateurs.setEmail(this.email);
        utilisateurs.setName(this.name);

        return utilisateurs;
    }
}
