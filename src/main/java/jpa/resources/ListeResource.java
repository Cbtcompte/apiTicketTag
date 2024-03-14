package jpa.resources;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.ResponseJpa;
import jpa.dtos.ListeDto;
import jpa.services.ListeService;
import jpa.validations.ListeValidation;

import java.util.List;


@Path("liste")
@Produces({"application/json", "application/xml"})
public class ListeResource {

    private ListeService listeService;
    private ListeValidation listeValidation;

    public ListeResource() {
        super();
        listeService = new ListeService();
        listeValidation = new ListeValidation();
    }


    @GET
    @Path("/all")
    public ResponseJpa getAllliste()  {
        List<ListeDto> l =  listeService.getAll();
        return new ResponseJpa(Response.ok().build().getStatus(), "Succes", l);
    }

    @GET
    @Path("/{id}")
    public ResponseJpa getliste(@PathParam("id") Long id)  {
        ListeDto l =  listeService.get(id);
       return new ResponseJpa(Response.ok().build().getStatus(), "Succes", l);
    }

    @POST
    @Consumes("application/json")
    public ResponseJpa addListe(@Parameter(description = "Pet object that needs to be added to the store", required = true) ListeDto l){
        listeValidation.rules(l);
        if(listeValidation.isError()){
            return new ResponseJpa(Response.status(402).build().getStatus(), "Les données ne sont pas correctes", listeValidation.getMessages());
        }
        try {
            listeService.add(l);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new ResponseJpa(Response.status(402).build().getStatus(), "Success", l);
    }

    @DELETE
    @Path("/{id}")
    public ResponseJpa deleteListe (@PathParam("id") Long id){
        listeService.delete(id);
        return new ResponseJpa(Response.status(402).build().getStatus(), "Success", listeValidation.getMessages());
    }
}
