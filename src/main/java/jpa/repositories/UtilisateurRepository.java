package jpa.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;
import jpa.JpaTest;
import jpa.models.Utilisateurs;
import jpa.repositories.interfaces.Repository;

public class UtilisateurRepository extends Repository< Utilisateurs> {

    public UtilisateurRepository() {
        super("utilisateurs");
    }

    public static void main(String[] args) {
		
		UtilisateurRepository test = new UtilisateurRepository();
        test.selectAll();
		System.out.println(".. done");
	}

}
