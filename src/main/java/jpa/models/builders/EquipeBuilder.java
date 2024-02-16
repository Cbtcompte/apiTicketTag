package jpa.models.builders;

import jpa.models.Equipes;

public class EquipeBuilder {
    private String name;

    public EquipeBuilder setName(String name) {
        this.name = name;

        return this;
    }

    public Equipes build(){
        Equipes equipes = new Equipes();
        equipes.setName(this.name);
        return equipes;
    }
}
