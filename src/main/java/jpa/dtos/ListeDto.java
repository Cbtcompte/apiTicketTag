package jpa.dtos;

import jpa.builders.ListeBuilder;
import jpa.models.Liste;
import jpa.models.Projet;

public class ListeDto {

    private Long id;
    private String titre;
    private Projet projet;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return this.titre;
    }

    public Long getId() {
        return this.id;
    }

    public Projet getProjet() {
        return this.projet;
    }


    public ListeDto fromEntity(Liste liste){
        ListeDto l = new ListeBuilder()
                .setId(liste.getId())
                .setTitre(liste.getTitre())
                .setProjet(liste.getProjet())
                .buildDto();

        return l;
    }
    public Liste toEntity(){
        Liste l = new ListeBuilder()
                .setTitre(this.titre)
                .setProjet(this.projet)
                .build();
        return l;
    }
}
