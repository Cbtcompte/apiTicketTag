package jpa.repositories;

import java.time.Instant;
import java.util.List;

import jpa.models.Equipes;
import jpa.models.Projects;
import jpa.models.builders.ProjectBuilder;
import jpa.repositories.subClasses.Repository;

public class ProjectRepository extends Repository<Projects>{
    public ProjectRepository() {
        super("Projects");
    }

    public static void main(String[] args) {
		
		ProjectRepository test = new ProjectRepository();
        EquipeRepository eR = new EquipeRepository();
        test.getManager();
        eR.getManager();
        // Projects projects = test.findById((long) 1);
        Equipes e = eR.findById((long) 1);
        // projects.setEquipe(e);
        // Projects projects = new ProjectBuilder()
        //                             .setDescription("")
        //                             .setEndProject(Instant.now())
        //                             .setStartProject(Instant.now())
        //                             .setTheme("Test Project")
        //                             .build();
        // test.create(projects);
        System.out.println(e.getId());
        List<Projects> uS = test.selectWithJoinFetch("equipe");
        test.closeManager();
        eR.closeManager();
        System.out.println("Length : "+ uS.get(0).toString());
		System.out.println(".. done");
	}
    
}
