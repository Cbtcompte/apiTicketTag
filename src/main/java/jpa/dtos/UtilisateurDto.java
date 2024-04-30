package jpa.dtos;

import jpa.builders.UtilisateurBuilder;
import jpa.models.Utilisateur;

public class UtilisateurDto {
    private Long id;
    private String name;
    private String email;


    public String getName() {
        return this.name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public  UtilisateurDto fromEntity(Utilisateur utilisateur){
        UtilisateurDto u = new UtilisateurBuilder()
                .setId(utilisateur.getId())
                .setEmail(utilisateur.getEmail())
                .setName(utilisateur.getName())
                .buildDto();
        return u;
    }
    public Utilisateur toEntity(){
        Utilisateur u = new UtilisateurBuilder()
                .setName(this.name)
                .setEmail(this.email)
                .build();
        return u;
    }
}
