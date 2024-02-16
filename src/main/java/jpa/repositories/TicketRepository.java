package jpa.repositories;

import java.util.List;

import jpa.models.Tickets;
import jpa.repositories.subClasses.Repository;

public class TicketRepository extends Repository<Tickets>{

    public TicketRepository() {
        super("Tickets");
    }

    public static void main(String[] args) {
		
		TicketRepository test = new TicketRepository();
        test.getManager();
        List<Tickets> uS = test.selectAll();
        test.closeManager();
        System.out.println("Length : "+ uS.size());
		System.out.println(".. done");
	}
    
    
}
