package jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;
import jpa.models.associativeTables.EquipeProjet;

@Entity
@Table(name = "equipes")
public class Equipe  extends GenerateCommonColumn{
    private String name;
    private List<EquipeProjet> equipeProjets;


    @OneToMany(mappedBy = "equipe")
    public List<EquipeProjet> getEquipeProjets() {
        return this.equipeProjets;
    }

    public void setEquipeProjets(List<EquipeProjet> equipeProjets) {
        this.equipeProjets = equipeProjets;
    }


    public Equipe() {}

    public Equipe(String name) {
        this.name = name;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
