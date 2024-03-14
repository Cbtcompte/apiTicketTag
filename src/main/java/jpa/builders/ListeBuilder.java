package jpa.builders;

import java.util.ArrayList;
import java.util.List;

import jpa.dtos.ListeDto;
import jpa.dtos.ProjetDto;
import jpa.dtos.TicketDto;
import jpa.models.Liste;
import jpa.models.Projet;
import jpa.models.Ticket;

public class ListeBuilder {

    private Long id;
    private String titre;
    private Projet projet;
    private List<Ticket> tickets;


    public ListeBuilder setTickets(List<Ticket> tickets) {
        this.tickets = tickets;

        return this;
    }

    public ListeBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ListeBuilder setTitre(String titre) {
        this.titre = titre;
        return this;
    }

    public ListeBuilder setProjet(Projet projet) {
        this.projet = projet;
        return this;
    }

    public Liste build(){
        Liste liste = new Liste();
        liste.setTitre(this.titre);
        liste.setProjet(this.projet);
        return liste;
    }

    public ListeDto buildDto(){
        TicketDto td = new TicketDto();
    
        List<TicketDto> ticketDtos = new ArrayList<>();

        for (Ticket ticket : this.tickets) {
            ticketDtos.add(td.fromEntity(ticket));
        }

        ListeDto listeDto = new ListeDto();
        listeDto.setId(this.id);
        listeDto.setTitre(this.titre);
        listeDto.setProjet(this.projet.getId());
        listeDto.setTicketDtos(ticketDtos);
        return listeDto;
    }


}
