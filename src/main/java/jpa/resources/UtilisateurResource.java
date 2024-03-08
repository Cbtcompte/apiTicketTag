package jpa.resources;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.dtos.UtilisateurDto;
import jpa.services.UtilisateurService;

import java.util.List;

@Path("utilisateur")
@Produces({"application/json", "application/xml"})
public class UtilisateurResource {

    private UtilisateurService utilisateurService;

    public UtilisateurResource() {
        super();
        utilisateurService = new UtilisateurService();
    }


    @GET
    @Path("/all")
    public List<UtilisateurDto> getAllutilisateur()  {
        List<UtilisateurDto> p =  utilisateurService.getAllUtilisateur();
        return p;
    }

    @GET
    @Path("/{id}")
    public UtilisateurDto getutilisateur(@PathParam("id") Long id)  {
        UtilisateurDto p =  utilisateurService.getUtilisateur(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    public Response addUtilisateur(@Parameter(description = "Pet object that needs to be added to the store", required = true) UtilisateurDto p){
        utilisateurService.addUtilisateur(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUtilisateur (@PathParam("id") Long id){
        utilisateurService.deleteUtilisateur(id);
        return Response.ok().entity("SUCCESS").build();
    }
}

