package jpa.resources;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.dtos.ListeDto;
import jpa.services.ListeService;

import java.util.List;


@Path("liste")
@Produces({"application/json", "application/xml"})
public class ListeResource {

    private ListeService listeService;

    public ListeResource() {
        super();
        listeService = new ListeService();
    }


    @GET
    @Path("/all")
    public List<ListeDto> getAllliste()  {
        List<ListeDto> p =  listeService.getAllListe();
        return p;
    }

    @GET
    @Path("/{id}")
    public ListeDto getliste(@PathParam("id") Long id)  {
        ListeDto p =  listeService.getListe(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    public Response addListe(@Parameter(description = "Pet object that needs to be added to the store", required = true) ListeDto p){
        listeService.addListe(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteListe (@PathParam("id") Long id){
        listeService.deleteListe(id);
        return Response.ok().entity("SUCCESS").build();
    }
}
