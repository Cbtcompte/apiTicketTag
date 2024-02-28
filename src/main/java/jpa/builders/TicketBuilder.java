package jpa.builders;

import java.time.Instant;
import jpa.models.Ticket;


public class TicketBuilder{

    private String libelle;
    private Boolean isClosed = false;
    private Boolean isForEveryOne = false;
    private Instant dateStart;
    private Instant dateEnd;

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

    public TicketBuilder setDateStart(Instant dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public TicketBuilder setDateEnd(Instant dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public Ticket build(){
        Ticket tickets = new Ticket();
        tickets.setDateEnd(this.dateEnd);
        tickets.setDateStart(this.dateStart);
        tickets.setIsClosed(this.isClosed);
        tickets.setIsForEveryOne(this.isForEveryOne);
        tickets.setLibelle(this.libelle);
        return null;
    }
}
