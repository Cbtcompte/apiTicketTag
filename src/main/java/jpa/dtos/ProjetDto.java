package jpa.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jpa.builders.ProjetBuilder;
import jpa.models.Projet;

public class ProjetDto implements Serializable{
    
    private Long id;
    private String theme;
    private String description;
    private String status = "En cours";
    private Date startProjet;
    private Date endProjet;
    private List<ListeDto> listeDtos = new ArrayList<>();


    public List<ListeDto> getListeDtos() {
        return this.listeDtos;
    }

    public void setListeDtos(List<ListeDto> listeDtos) {
        this.listeDtos = listeDtos;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    public ProjetDto fromEntity(Projet projet){
        ProjetDto p = new ProjetBuilder()
                    .setId(projet.getId())
                    .setDescription(projet.getDescription())
                    .setEndProjet(projet.getEndProjet())
                    .setStatus(projet.getStatus())
                    .setStartProjet(projet.getStartProjet())
                    .setTheme(projet.getTheme())
                    .setListes(projet.getListes())
                    .buildDto();
        return p;
    }

    public ProjetDto fromEntityWithoutList(Projet projet){
        ProjetDto p = new ProjetBuilder()
                    .setId(projet.getId())
                    .setDescription(projet.getDescription())
                    .setEndProjet(projet.getEndProjet())
                    .setStatus(projet.getStatus())
                    .setStartProjet(projet.getStartProjet())
                    .setTheme(projet.getTheme())
                    .buildDtoWithoutList();
        return p;
    }

    public Projet toEntity(){
        Projet p = new ProjetBuilder()
                    .setDescription(this.description)
                    .setEndProjet(this.endProjet)
                    .setStatus(this.status)
                    .setStartProjet(this.startProjet)
                    .setTheme(this.theme)
                    .build();
                                            
        return p;
    }

   // public Parsy toJson(){

   // }
}
