package jpa.builders;

import jpa.dtos.ListeDto;
import jpa.models.Liste;
import jpa.models.Projet;

public class ListeBuilder {

    private String titre;
    private Projet projet;

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
        listeDto.setTitre(titre);
        listeDto.setProjet(projet);
        return listeDto;
    }


}
