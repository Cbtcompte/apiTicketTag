package jpa.repositories;

import jpa.models.Utilisateur;
import jpa.repositories.subClasses.Repository;

public class UtilisateurRepository extends Repository< Utilisateur> {

    public UtilisateurRepository() {
        super("Utilisateur");
    }


}
