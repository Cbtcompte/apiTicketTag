package jpa.dtos;

import jpa.builders.UtilisateurBuilder;
import jpa.models.Utilisateur;

public class UtilisateurDto {

    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public  UtilisateurDto fromEntity(Utilisateur utilisateur){
        UtilisateurDto u = new UtilisateurBuilder()
                .setEmail(utilisateur.getEmail())
                .setName(utilisateur.getName())
                .buildDto();
        return u;
    }
    public Utilisateur toEntity(){
        Utilisateur u = new UtilisateurBuilder()
                .setEmail(this.email)
                .setEmail(this.email)
                .build();
        return u;
    }
}
