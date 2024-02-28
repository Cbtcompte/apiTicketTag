package jpa.repositories;

import java.util.List;

import jpa.models.Utilisateur;
import jpa.repositories.subClasses.Repository;

public class UtilisateurRepository extends Repository< Utilisateur> {

    public UtilisateurRepository() {
        super("Utilisateur");
    }


}
