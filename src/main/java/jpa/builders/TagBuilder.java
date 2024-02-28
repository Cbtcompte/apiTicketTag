package jpa.builders;

import jpa.dtos.TagDto;
import jpa.models.Tag;

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

    public Tag build(){
        Tag tags = new Tag();
        tags.setCouleur(this.couleur);
        tags.setLibelle(this.libelle);

        return tags;
    }

    public TagDto buildDto(){
        TagDto tagDto = new TagDto();
        tagDto.setCouleur(this.couleur);
        tagDto.setLibelle(this.libelle);

        return tagDto;
    }

}
