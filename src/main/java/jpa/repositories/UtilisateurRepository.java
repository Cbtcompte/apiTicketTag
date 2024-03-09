package jpa.repositories;

import jpa.models.Utilisateur;
import jpa.repositories.abstracts.Repository;

public class UtilisateurRepository extends Repository< Utilisateur> {

    public UtilisateurRepository() {
        super("Utilisateur");
    }


}
