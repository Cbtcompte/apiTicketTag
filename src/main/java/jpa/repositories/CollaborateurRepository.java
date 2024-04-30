package jpa.repositories;

import jpa.models.associativeTables.Collaborateur;
import jpa.repositories.abstracts.Repository;

public class CollaborateurRepository extends Repository<Collaborateur> {
    public CollaborateurRepository(){
        super("Collaborateur");
    }
}
