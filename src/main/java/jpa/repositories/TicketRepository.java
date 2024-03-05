package jpa.repositories;

import jpa.models.Ticket;
import jpa.repositories.subClasses.Repository;

public class TicketRepository extends Repository<Ticket>{

    public TicketRepository() {
        super("Ticket");
    }


    
    
}
