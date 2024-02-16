package jpa.models.builders;

import java.time.Instant;

import jpa.models.Equipes;
import jpa.models.Projects;

public class ProjectBuilder {
    private String theme;
    private String description;
    private Instant startProject;
    private Instant endProject;
    private Instant startReelProject;
    private Instant endReelProject;
    private Equipes equipe;

    public ProjectBuilder setEquipe(Equipes equipe) {
        this.equipe = equipe;
        return this;
    }    

    public ProjectBuilder setTheme(String theme) {
        this.theme = theme;
        return this;
    }

    public ProjectBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder setStartProject(Instant startProject) {
        this.startProject = startProject;
        return this;
    }

    public ProjectBuilder setEndProject(Instant endProject) {
        this.endProject = endProject;
        return this;
    }

    public ProjectBuilder setStartReelProject(Instant startReelProject) {
        this.startReelProject = startReelProject;
        return this;
    }

    public ProjectBuilder setEndReelProject(Instant endReelProject) {
        this.endReelProject = endReelProject;
        return this;
    }

    public Projects build(){
        Projects projects = new Projects();
        projects.setDescription(this.description);
        projects.setEquipe(this.equipe);
        projects.setEndProject(this.endProject);
        projects.setEndReelProject(this.endReelProject);
        projects.setStartProject(this.startProject);
        projects.setStartReelProject(this.startReelProject);
        projects.setTheme(this.theme);
        
        return projects;
    }
}
