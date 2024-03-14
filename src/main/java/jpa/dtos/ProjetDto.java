package jpa.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jpa.builders.ProjetBuilder;
import jpa.models.Projet;

public class ProjetDto implements Serializable{
    
    private Long id;
    private String theme;
    private String description;
    private Date startProjet;
    private Date endProjet;
    private Date startReelProjet;
    private Date endReelProjet;
    private List<ListeDto> listeDtos;


    public List<ListeDto> getListeDtos() {
        return this.listeDtos;
    }

    public void setListeDtos(List<ListeDto> listeDtos) {
        this.listeDtos = listeDtos;
    }

    public Long getId() {
        return this.id;
    }

    public String getTheme() {
        return this.theme;
    }


    public String getDescription() {
        return this.description;
    }


    public Date getStartProjet() {
        return this.startProjet;
    }


    public Date getEndProjet() {
        return this.endProjet;
    }


    public Date getStartReelProjet() {
        return this.startReelProjet;
    }


    public Date getEndReelProjet() {
        return this.endReelProjet;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setId(Long id) {
        this.id = id;
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
                    .setId(projet.getId())
                    .setDescription(projet.getDescription())
                    .setEndProjet(projet.getEndProjet())
                    .setEndReelProjet(projet.getEndReelProjet())
                    .setStartProjet(projet.getStartProjet())
                    .setStartReelProjet(projet.getStartReelProjet())
                    .setTheme(projet.getTheme())
                    .setListes(projet.getListes())
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
