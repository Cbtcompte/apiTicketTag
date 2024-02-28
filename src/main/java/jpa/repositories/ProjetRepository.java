package jpa.repositories;

import java.time.Instant;
import java.util.List;

import jpa.builders.ProjetBuilder;
import jpa.models.Collaborateur;
import jpa.models.Projet;
import jpa.models.Utilisateur;
import jpa.repositories.subClasses.Repository;

public class ProjetRepository extends Repository<Projet>{
    public ProjetRepository() {
        super("Projet");
    }

    // public static void main(String[] args) {
		
	// 	ProjetRepository test = new ProjetRepository();
    //     test.getManager();
    //     List<Projet> uS = test.selectAll();
    //     test.closeManager();
    //     System.out.println("Length : "+ uS.size());
	// 	System.out.println(".. done");
	// }
    
}
