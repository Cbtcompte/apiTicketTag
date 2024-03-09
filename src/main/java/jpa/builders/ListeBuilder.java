package jpa.builders;

import jpa.dtos.ListeDto;
import jpa.models.Liste;
import jpa.models.Projet;

public class ListeBuilder {

    private Long id;
    private String titre;
    private Projet projet;

    public ListeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ListeBuilder setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public ListeBuilder setProjet(Projet projet) {
        this.projet = projet;
        return this;
    }

    public Liste build(){
        Liste liste = new Liste();
        liste.setTitre(this.titre);
        liste.setProjet(this.projet);
        return liste;
    }

    public ListeDto buildDto(){
        ListeDto listeDto = new ListeDto();
        listeDto.setId(this.id);
        listeDto.setTitre(this.titre);
        listeDto.setProjet(this.projet);
        return listeDto;
    }


}
