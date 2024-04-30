package jpa.resources;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.dtos.CollaborateurDto;
import jpa.services.CollaborateurService;

import java.util.List;

@Path("api/collaborateur")
@Produces({"application/json", "application/xml"})
public class CollaborateurResource {

    private CollaborateurService collaborateurService;

    public CollaborateurResource() {
        super();
        collaborateurService = new CollaborateurService();
    }


    @GET
    @Path("/all")
    public List<CollaborateurDto> getAllcollaborateur()  {
        List<CollaborateurDto> p =  collaborateurService.getAllCollaborateur();
        return p;
    }

    @GET
    @Path("/{id}")
    public CollaborateurDto getcollaborateur(@PathParam("id") Long id)  {
        CollaborateurDto p =  collaborateurService.getCollaborateur(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    public Response addCollaborateur(@Parameter(description = "Pet object that needs to be added to the store", required = true) CollaborateurDto p){
        collaborateurService.addCollaborateur(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCollaborateur (@PathParam("id") Long id){
        collaborateurService.deleteCollaborateur(id);
        return Response.ok().entity("SUCCESS").build();
    }
}

