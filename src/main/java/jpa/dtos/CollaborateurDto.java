package jpa.dtos;


import jpa.builders.CollaborateurBuilder;
import jpa.models.Projet;
import jpa.models.Utilisateur;
import jpa.models.associativeTables.Collaborateur;

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
                .setName(collaborateur.getName())
                .builDto();
        return c;
    }
    public Collaborateur toEntity(){
        Collaborateur c = new CollaborateurBuilder()
                .setName(this.name)
                .setUtilisateur(this.utilisateur)
                .build();
        return c;

    }
}
