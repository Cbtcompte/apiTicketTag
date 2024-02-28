package jpa.builders;

import java.time.Instant;

import jpa.dtos.ProjetDto;
import jpa.models.Projet;

public class ProjetBuilder {
    private String theme;
    private String description;
    private Instant startProjet;
    private Instant endProjet;
    private Instant startReelProjet;
    private Instant endReelProjet;

    public ProjetBuilder setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public ProjetBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjetBuilder setStartProjet(Instant startProjet) {
        this.startProjet = startProjet;
        return this;
    }

    public ProjetBuilder setEndProjet(Instant endProjet) {
        this.endProjet = endProjet;
        return this;
    }

    public ProjetBuilder setStartReelProjet(Instant startReelProjet) {
        this.startReelProjet = startReelProjet;
        return this;
    }

    public ProjetBuilder setEndReelProjet(Instant endReelProjet) {
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


    // public ProjetDto buildDto(){
    //     ProjetDto projets = new Projet();
    //     projets.setDescription(this.description);
    //     projets.setEndProjet(this.endProjet);
    //     projets.setEndReelProjet(this.endReelProjet);
    //     projets.setStartProjet(this.startProjet);
    //     projets.setStartReelProjet(this.startReelProjet);
    //     projets.setTheme(this.theme);

    //     return projets;
    // }
}
