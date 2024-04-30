package jpa.repositories;

import jpa.models.Equipe;
import jpa.repositories.abstracts.Repository;

public class EquipeRepository extends Repository<Equipe>{
    public  EquipeRepository (){
        super("Equipe");
    }
}
