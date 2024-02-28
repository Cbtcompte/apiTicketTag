package jpa.dtos;

import jpa.builders.TicketBuilder;
import jpa.models.Liste;
import jpa.models.Ticket;

import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Date;

public class TicketDto {
    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Date dateStart;
    private Date dateEnd;
    private Liste liste;

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }

    public void setForEveryOne(Boolean forEveryOne) {
        isForEveryOne = forEveryOne;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }


    public void setListe(Liste liste) {
        this.liste = liste;
    }


    public TicketDto fromEntity(Ticket ticket){
        TicketDto t = new TicketBuilder()
                .setLibelle(ticket.getLibelle())
                .setIsClosed(ticket.getIsClosed())
                .setIsForEveryOne(ticket.getIsForEveryOne())
                .setDateStart(ticket.getDateStart())
                .setDateEnd(ticket.getDateEnd())
                .buildDto();
        return t;
    }
    public Ticket toEntity(){
        Ticket t = new TicketBuilder()
                .setLibelle(this.libelle)
                .setIsClosed(this.isClosed)
                .setIsForEveryOne(this.isForEveryOne)
                .setDateStart(this.dateStart)
                .setDateEnd(this.dateEnd)
                .build();

        return t;
    }
}
