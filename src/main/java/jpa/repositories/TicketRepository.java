package jpa.repositories;

import jpa.models.Ticket;
import jpa.repositories.abstracts.Repository;

public class TicketRepository extends Repository<Ticket>{

    public TicketRepository() {
        super("Ticket");
    }


    
    
}
