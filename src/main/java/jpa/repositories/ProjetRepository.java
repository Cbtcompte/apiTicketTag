package jpa.repositories;

import java.time.Instant;
import java.util.List;

import jpa.builders.ProjetBuilder;
import jpa.models.Collaborateur;
import jpa.models.Projet;
import jpa.repositories.subClasses.Repository;

public class ProjetRepository extends Repository<Projet>{
    public ProjetRepository() {
        super("Projects");
    }

    public static void main(String[] args) {
		
		ProjetRepository test = new ProjetRepository();
        EquipeRepository eR = new EquipeRepository();
        test.getManager();
        eR.getManager();
        // Projects projects = test.findById((long) 1);
        Collaborateur e = eR.findById((long) 1);
        // projects.setEquipe(e);
        // Projects projects = new ProjectBuilder()
        //                             .setDescription("")
        //                             .setEndProject(Instant.now())
        //                             .setStartProject(Instant.now())
        //                             .setTheme("Test Project")
        //                             .build();
        // test.create(projects);
        System.out.println(e.getId());
        List<Projet> uS = test.selectWithJoinFetch("equipe");
        test.closeManager();
        eR.closeManager();
        System.out.println("Length : "+ uS.get(0).toString());
		System.out.println(".. done");
	}
    
}
