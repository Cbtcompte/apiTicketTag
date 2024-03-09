package jpa.repositories;

import jpa.models.Liste;
import jpa.repositories.abstracts.Repository;

public class ListeRepository extends Repository<Liste> {

    public  ListeRepository (){
        super("Liste");
    }

    
}
