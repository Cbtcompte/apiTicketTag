package jpa.builders;

import jpa.dtos.UtilisateurDto;
import jpa.models.Utilisateur;

public class UtilisateurBuilder {
    private Long id;
    private String name;
    private String email;


    public UtilisateurBuilder setId(Long id) {
        this.id = id;
        return this;
    }

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

    public UtilisateurDto buildDto(){
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(this.id);
        utilisateurDto.setName(this.name);
        utilisateurDto.setEmail(this.email);

        return  utilisateurDto;
    }
}
