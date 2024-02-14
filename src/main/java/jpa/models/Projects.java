package jpa.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jpa.models.abstracts.GenerateCommonColumn;

@Entity
@Table(name = "projects")
public class Projects extends GenerateCommonColumn {
    private String theme;
    private String description;
    private Instant startProject;
    private Instant endProject;
    private Instant startReelProject;
    private Instant endReelProject;
    private Equipes equipe;

    @ManyToOne
    @JoinColumn(name = "equipe_id", nullable = false)
    public Equipes getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Equipes equipe) {
        this.equipe = equipe;
    }    

    @Column(name = "theme", nullable = false)
    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "startProject", nullable = false)
    public Instant getStartProject() {
        return this.startProject;
    }

    public void setStartProject(Instant startProject) {
        this.startProject = startProject;
    }

    @Column(name = "endProject", nullable = false)
    public Instant getEndProject() {
        return this.endProject;
    }

    public void setEndProject(Instant endProject) {
        this.endProject = endProject;
    }

    @Column(name = "startReelProject", nullable = true)
    public Instant getStartReelProject() {
        return this.startReelProject;
    }

    public void setStartReelProject(Instant startReelProject) {
        this.startReelProject = startReelProject;
    }

    @Column(name = "endReelProject", nullable =  true)
    public Instant getEndReelProject() {
        return this.endReelProject;
    }

    public void setEndReelProject(Instant endReelProject) {
        this.endReelProject = endReelProject;
    }

}
