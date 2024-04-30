package jpa.builders;

import jpa.dtos.EquipeDto;
import jpa.models.Equipe;

public class EquipeBuilder {
    private Long id;
    private String name;

    public EquipeBuilder setName(String name) {
        this.name = name;
        return this;
    }


    public EquipeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public Equipe build(){
        Equipe equipe = new Equipe();
        equipe.setName(this.name);

        return equipe;
    }

    public EquipeDto buildDto(){
        EquipeDto equipeDto = new EquipeDto();
        equipeDto.setId(this.id);
        equipeDto.setName(this.name);

        return  equipeDto;
    }
}
