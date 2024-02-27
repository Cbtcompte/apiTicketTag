package jpa.repositories;

import java.util.List;

import jpa.models.Utilisateur;
import jpa.repositories.subClasses.Repository;

public class UtilisateurRepository extends Repository< Utilisateur> {

    public UtilisateurRepository() {
        super("Utilisateur");
    }

    public static void main(String[] args) {
		
		UtilisateurRepository test = new UtilisateurRepository();
        test.getManager();
        List<Utilisateur> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}

}
