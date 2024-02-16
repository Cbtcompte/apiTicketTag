package jpa.models.builders;

import jpa.models.Tags;

public class TagBuilder{

    private String libelle;
    private String couleur;

    public TagBuilder setLibelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public TagBuilder setCouleur(String couleur) {
        this.couleur = couleur;

        return this;
    }

    public Tags build(){
        Tags tags = new Tags();
        tags.setCouleur(this.couleur);
        tags.setLibelle(this.libelle);

        return tags;
    }

}
