package jpa.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.builders.ProjetBuilder;
import jpa.dtos.ProjetDto;
import jpa.models.Projet;
import jpa.services.ProjetService;
import jpa.utils.Formatter;


@Path("projet")
@Produces({"application/json", "application/xml"})
public class ProjetResource{
    private ProjetService projetService;

    public ProjetResource() {
        super();
        projetService = new ProjetService();
    }


    @GET
    @Path("/all")
    public List<ProjetDto> getAllprojet()  {
        List<ProjetDto> p =  projetService.getAllProjet();
       return p;
    }

    @GET
    @Path("/{id}")
    public ProjetDto getprojet(@PathParam("id") Long id)  {
       ProjetDto p =  projetService.getProjet(id);
       return p;
    }

    @POST
    @Consumes("application/json")
    public Response addProjet(@Parameter(description = "Pet object that needs to be added to the store", required = true) ProjetDto p){
        projetService.addProjet(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
   public Response deleteProjet (@PathParam("id") Long id){
        projetService.deleteProjet(id);
        return Response.ok().entity("SUCCESS").build();
    }
}
