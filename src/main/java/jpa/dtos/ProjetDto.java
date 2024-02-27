package jpa.dtos;

import java.time.Instant;

import jpa.builders.ProjetBuilder;
import jpa.models.Projet;

public class ProjetDto {
    private String theme;
    private String description;
    private Instant startProjet;
    private Instant endProjet;
    private Instant startReelProjet;
    private Instant endReelProjet;

    public ProjetDto fromEntity(Projet projet){
        
        return this;
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
}
