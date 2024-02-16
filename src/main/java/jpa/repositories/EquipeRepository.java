package jpa.repositories;

import java.util.List;

import jpa.models.Equipes;
import jpa.models.builders.EquipeBuilder;
import jpa.repositories.subClasses.Repository;

public class EquipeRepository extends Repository<Equipes> {

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
        List<Equipes> eq = test.selectWithJoinFetch("projects");
        test.closeManager();
        System.out.println(eq.get(0).getProjects().size());
		System.out.println(".. done");
	}
}
