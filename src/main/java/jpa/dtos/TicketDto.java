package jpa.dtos;

import jpa.builders.TicketBuilder;
import jpa.models.Liste;
import jpa.models.Ticket;

import java.util.Date;

public class TicketDto {

    private Long id;
    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Date dateStart;
    private Date dateEnd;
    private Long liste;


    public String getLibelle() {
        return this.libelle;
    }


    public Boolean isIsClosed() {
        return this.isClosed;
    }

    public Boolean getIsClosed() {
        return this.isClosed;
    }


    public Boolean isIsForEveryOne() {
        return this.isForEveryOne;
    }

    public Boolean getIsForEveryOne() {
        return this.isForEveryOne;
    }


    public Date getDateStart() {
        return this.dateStart;
    }


    public Date getDateEnd() {
        return this.dateEnd;
    }


    public Long getListe() {
        return this.liste;
    }

    public Long getId() {
        return this.id;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIsClosed(Boolean closed) {
        isClosed = closed;
    }

    public void setIsForEveryOne(Boolean forEveryOne) {
        isForEveryOne = forEveryOne;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }


    public void setListe(Long liste) {
        this.liste = liste;
    }


    public TicketDto fromEntity(Ticket ticket){
        TicketDto t = new TicketBuilder()
                .setId(ticket.getId())
                .setLibelle(ticket.getLibelle())
                .setIsClosed(ticket.getIsClosed())
                .setIsForEveryOne(ticket.getIsForEveryOne())
                .setDateStart(ticket.getDateStart())
                .setDateEnd(ticket.getDateEnd())
                .setListe(ticket.getListe())
                .buildDto();
        return t;
    }
    
    public Ticket toEntity(Liste l){
        Ticket t = new TicketBuilder()
                .setLibelle(this.libelle)
                .setIsClosed(this.isClosed)
                .setIsForEveryOne(this.isForEveryOne)
                .setDateStart(this.dateStart)
                .setDateEnd(this.dateEnd)
                .setListe(l)
                .build();

        return t;
    }
}
