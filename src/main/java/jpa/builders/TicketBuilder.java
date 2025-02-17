package jpa.builders;

import java.util.Date;

import jpa.dtos.TicketDto;
import jpa.models.Liste;
import jpa.models.Ticket;


public class TicketBuilder{

    private Long id;
    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Date dateStart;
    private Date dateEnd;
    private Liste liste;

    public TicketBuilder setListe(Liste liste) {
        this.liste = liste;
        return this;
    }

    public TicketBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public TicketBuilder setLibelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public TicketBuilder setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
        return this;
    }


    public TicketBuilder setIsForEveryOne(Boolean isForEveryOne) {
        this.isForEveryOne = isForEveryOne;
        return this;
    }

    public TicketBuilder setDateStart(Date dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public TicketBuilder setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Ticket build(){
        Ticket tickets = new Ticket();
        tickets.setDateEnd(this.dateEnd);
        tickets.setDateStart(this.dateStart);
        tickets.setIsClosed(this.isClosed);
        tickets.setIsForEveryOne(this.isForEveryOne);
        tickets.setListe(this.liste);
        tickets.setLibelle(this.libelle);

        return tickets;
    }

    public TicketDto buildDto(){
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(this.id);
        ticketDto.setDateEnd(this.dateEnd);
        ticketDto.setDateStart(this.dateStart);
        ticketDto.setListe(this.liste.getId());
        ticketDto.setIsClosed(this.isClosed);
        ticketDto.setIsForEveryOne(this.isForEveryOne);
        ticketDto.setLibelle(this.libelle);

        return ticketDto;
    }

}
