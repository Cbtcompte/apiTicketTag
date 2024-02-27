package jpa.repositories;

import java.util.List;

import jpa.builders.CollaborateurBuilder;
import jpa.models.Collaborateur;
import jpa.repositories.subClasses.Repository;

public class EquipeRepository extends Repository<Collaborateur> {

    public EquipeRepository() {
        super("Equipes");
    }

    public static void main(String[] args) {
		EquipeRepository test = new EquipeRepository();
        test.getManager();
        // Equipes e = test.findById((long) 1);
        // e.setName("New name");
        //test.create(e);
        //test.create(new EquipeBuilder().setName("Equipe 1").build());
        List<Collaborateur> eq = test.selectWithJoinFetch("projects");
        test.closeManager();
        // System.out.println(eq.get(0).getProjets().size());
		System.out.println(".. done");
	}
}
