package jpa.repositories;

import jpa.models.Collaborateur;
import jpa.repositories.abstracts.Repository;

public class CollaborateurRepository extends Repository<Collaborateur> {
    public CollaborateurRepository(){
        super("Collaborateur");
    }
}
