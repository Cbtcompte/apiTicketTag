package jpa.dtos;


import jpa.builders.CollaborateurBuilder;
import jpa.models.Collaborateur;
import jpa.models.Projet;
import jpa.models.Utilisateur;

public class CollaborateurDto {
    private String name;
    private Utilisateur utilisateur;
    private Projet projet;

    public void setName(String name) {
        this.name = name;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public CollaborateurDto fromEntity(Collaborateur collaborateur){
        CollaborateurDto c = new CollaborateurBuilder()
                .setProjet(collaborateur.getProjet())
                .setName(collaborateur.getName())
                .builDto();
        return c;
    }
    public Collaborateur toEntity(){
        Collaborateur c = new CollaborateurBuilder()
                .setName(this.name)
                .setProjet(this.projet)
                .setUtilisateur(this.utilisateur)
                .build();
        return c;

    }
}
