package jpa.resources;

import java.util.List;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.ResponseJpa;
import jpa.dtos.ProjetDto;
import jpa.resources.abstracts.Resource;
import jpa.services.ProjetService;
import jpa.validations.ProjetValidation;


@Path("projet")
@Produces({"application/json", "application/xml"})
public class ProjetResource extends Resource<ProjetService, ProjetValidation, ProjetDto> {
    // private ProjetService projetService;
    // private ProjetValidation projetValidation;

    public ProjetResource() {
        super(ProjetService.class, ProjetValidation.class);
        // projetService = new ProjetService();
        // projetValidation = new ProjetValidation();
    }

    // @GET
    // @Path("/all")
    // public ResponseJpa getAllprojet()  {
    //     List<ProjetDto> p =  projetService.getAll();
    //    return new ResponseJpa(Response.ok().build().getStatus(), "Succes", p);
    // }

    // @GET
    // @Path("/{id}")
    // public ResponseJpa getprojet(@PathParam("id") Long id)  {
    //    ProjetDto p =  projetService.get(id);
    //    return new ResponseJpa(Response.ok().build().getStatus(), "Succes", p);
    // }

    // @POST
    // @Consumes("application/json")
    // public ResponseJpa createProjet(@Parameter(description = "Pet object that needs to be added to the store", required = true) ProjetDto p){
    //     projetValidation.rules(p);
    //     if(projetValidation.isError()){
    //         return new ResponseJpa(Response.status(402).build().getStatus(), "Les données ne sont pas correctes", projetValidation.getMessages());
    //     }
    //     try {
    //         projetService.add(p);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return new ResponseJpa(Response.ok().build().getStatus(), "Success", p);
    // }

    // @DELETE
    // @Path("/{id}")
    // public ResponseJpa delete(@PathParam("id") Long id){
    //     projetService.delete(id);
    //     return new ResponseJpa(Response.ok().build().getStatus(), "Projet Supprimé", null);
    // }
}
