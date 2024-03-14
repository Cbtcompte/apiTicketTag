package jpa.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jpa.dtos.TicketDto;
import jpa.resources.abstracts.Resource;
import jpa.services.TicketService;
import jpa.validations.TicketValidation;

@Path("ticket")
@Produces({"application/json", "application/xml"})
public class TicketResource extends Resource<TicketService, TicketValidation, TicketDto>{

    public TicketResource() {
        super(TicketService.class, TicketValidation.class);
    }
}
