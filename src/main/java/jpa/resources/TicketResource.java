package jpa.resources;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.dtos.TicketDto;
import jpa.services.TicketService;

import java.util.List;

@Path("ticket")
@Produces({"application/json", "application/xml"})
public class TicketResource {

    private TicketService ticketService;

    public TicketResource() {
        super();
        ticketService = new TicketService();
    }


    @GET
    @Path("/all")
    public List<TicketDto> getAllticket()  {
        List<TicketDto> p =  ticketService.getAllTicket();
        return p;
    }

    @GET
    @Path("/{id}")
    public TicketDto getticket(@PathParam("id") Long id)  {
        TicketDto p =  ticketService.getTicket(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    public Response addTicket(@Parameter(description = "Pet object that needs to be added to the store", required = true) TicketDto p){
        ticketService.addTicket(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTicket (@PathParam("id") Long id){
        ticketService.deleteTicket(id);
        return Response.ok().entity("SUCCESS").build();
    }
}
