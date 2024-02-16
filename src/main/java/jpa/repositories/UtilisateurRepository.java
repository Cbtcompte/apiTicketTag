package jpa.repositories;

import java.util.List;

import jpa.models.Utilisateurs;
import jpa.repositories.subClasses.Repository;

public class UtilisateurRepository extends Repository< Utilisateurs> {

    public UtilisateurRepository() {
        super("Utilisateurs");
    }

    public static void main(String[] args) {
		
		UtilisateurRepository test = new UtilisateurRepository();
        test.getManager();
        List<Utilisateurs> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}

}
