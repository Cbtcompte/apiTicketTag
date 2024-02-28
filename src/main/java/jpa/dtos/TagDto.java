package jpa.dtos;


import jpa.builders.TagBuilder;
import jpa.models.Tag;

public class TagDto {
    private String libelle;
    private String couleur;

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public TagDto fromEntity(Tag tag){
        TagDto t = new TagBuilder()
                .setCouleur(tag.getCouleur())
                .setLibelle(tag.getLibelle())
                .buildDto();

        return t;
    }
    public Tag toEntity(){
        Tag t = new TagBuilder()
                .setCouleur(this.couleur)
                .setLibelle(this.libelle)
                .build();
        return t;
    }
}
