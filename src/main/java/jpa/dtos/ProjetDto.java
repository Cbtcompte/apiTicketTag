package jpa.dtos;

import java.io.Serializable;
import java.util.Date;

import jpa.builders.ProjetBuilder;
import jpa.models.Projet;

public class ProjetDto implements Serializable {
    private String theme;
    private String description;
    private Date startProjet;
    private Date endProjet;
    private Date startReelProjet;
    private Date endReelProjet;

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartProjet(Date startProjet) {
        this.startProjet = startProjet;
    }

    public void setEndProjet(Date endProjet) {
        this.endProjet = endProjet;
    }

    public void setStartReelProjet(Date startReelProjet) {
        this.startReelProjet = startReelProjet;
    }

    public void setEndReelProjet(Date endReelProjet) {
        this.endReelProjet = endReelProjet;
    }

    
    public ProjetDto fromEntity(Projet projet){
        ProjetDto p = new ProjetBuilder()
                    .setDescription(projet.getDescription())
                    .setEndProjet(projet.getEndProjet())
                    .setEndReelProjet(projet.getEndReelProjet())
                    .setStartProjet(projet.getStartProjet())
                    .setStartReelProjet(projet.getStartReelProjet())
                    .setTheme(projet.getTheme())
                    .buildDto();
        return p;
    }

    public Projet toEntity(){
        Projet p = new ProjetBuilder()
                    .setDescription(this.description)
                    .setEndProjet(this.endProjet)
                    .setEndReelProjet(this.endReelProjet)
                    .setStartProjet(this.startProjet)
                    .setStartReelProjet(this.startReelProjet)
                    .setTheme(this.theme)
                    .build();
                                            
        return p;
    }

   // public Parsy toJson(){

   // }
}
