package jpa.dtos;

import java.util.ArrayList;
import java.util.List;

import jpa.builders.ListeBuilder;
import jpa.models.Liste;
import jpa.models.Projet;

public class ListeDto {

    private Long id;
    private String titre;
    private Long projet;
    private List<TicketDto> ticketDtos = new ArrayList<>();

    public List<TicketDto> getTicketDtos() {
        return this.ticketDtos;
    }

    public void setTicketDtos(List<TicketDto> ticketDtos) {
        this.ticketDtos = ticketDtos;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjet(Long projet) {
        this.projet = projet;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return this.titre;
    }

    public Long getId() {
        return this.id;
    }

    public Long getProjet() {
        return this.projet;
    }


    public ListeDto fromEntity(Liste liste){
        ListeDto l = new ListeBuilder()
                .setId(liste.getId())
                .setTitre(liste.getTitre())
                .setProjet(liste.getProjet())
                .setTickets(liste.getTickets())
                .buildDto();
        return l;
    }

    public Liste toEntity(Projet p){
        Liste l = new ListeBuilder()
                .setTitre(this.titre)
                .setProjet(p)
                .build();
        return l;
    }
}
