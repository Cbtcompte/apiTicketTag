package jpa.dtos;

import jpa.builders.EquipeBuilder;
import jpa.models.Equipe;

public class EquipeDto {
    private Long id;
    private String name;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  EquipeDto fromEntity(Equipe equipe){
        EquipeDto e = new EquipeBuilder()
                .setId(equipe.getId())
                .setName(equipe.getName())
                .buildDto();
        return e;
    }
    public Equipe toEntity(){
        Equipe e = new EquipeBuilder()
                .setName(this.name)
                .build();
        return e;
    }
}
