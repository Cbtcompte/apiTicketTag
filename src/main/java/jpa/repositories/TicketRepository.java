package jpa.repositories;

import java.util.List;

import jpa.models.Ticket;
import jpa.repositories.subClasses.Repository;

public class TicketRepository extends Repository<Ticket>{

    public TicketRepository() {
        super("Ticket");
    }

    public static void main(String[] args) {
		
		TicketRepository test = new TicketRepository();
        test.getManager();
        List<Ticket> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
    
    
}
