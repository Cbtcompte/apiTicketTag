package jpa.repositories;

import jpa.models.Projet;
import jpa.repositories.abstracts.Repository;

public class ProjetRepository extends Repository<Projet>{
    public ProjetRepository() {
        super("Projet");
    }

    
}
