package jpa.builders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jpa.dtos.ListeDto;
import jpa.dtos.ProjetDto;
import jpa.models.Liste;
import jpa.models.Projet;

public class ProjetBuilder {
    private Long id;
    private String theme;
    private String description;
    private Date startProjet;
    private Date endProjet;
    private Date startReelProjet;
    private Date endReelProjet;
    private List<Liste> listes;


    public ProjetBuilder setListes(List<Liste> listes) {
        this.listes = listes;
        return this;
    }

    public ProjetBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProjetBuilder setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public ProjetBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjetBuilder setStartProjet(Date startProjet) {
        this.startProjet = startProjet;
        return this;
    }

    public ProjetBuilder setEndProjet(Date endProjet) {
        this.endProjet = endProjet;
        return this;
    }

    public ProjetBuilder setStartReelProjet(Date startReelProjet) {
        this.startReelProjet = startReelProjet;
        return this;
    }

    public ProjetBuilder setEndReelProjet(Date endReelProjet) {
        this.endReelProjet = endReelProjet;
        return this;
    }
    
    public Projet build(){
        Projet projets = new Projet();
        projets.setDescription(this.description);
        projets.setEndProjet(this.endProjet);
        projets.setEndReelProjet(this.endReelProjet);
        projets.setStartProjet(this.startProjet);
        projets.setStartReelProjet(this.startReelProjet);
        projets.setTheme(this.theme);

        return projets;
    }


    public ProjetDto buildDto(){
        ListeDto lD = new ListeDto();
        List<ListeDto> listeDtos = new ArrayList<>();
        ProjetDto projetsDto = new ProjetDto();

        for (Liste liste : this.listes) {
            listeDtos.add(lD.fromEntity(liste));
        }
        projetsDto.setId(this.id);
        projetsDto.setDescription(this.description);
        projetsDto.setEndProjet(this.endProjet);
        projetsDto.setEndReelProjet(this.endReelProjet);
        projetsDto.setStartProjet(this.startProjet);
        projetsDto.setStartReelProjet(this.startReelProjet);
        projetsDto.setTheme(this.theme);
        projetsDto.setListeDtos(listeDtos);

        return projetsDto;
    }

}
