package jpa.resources;


import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jpa.ResponseJpa;
import jpa.dtos.ListeDto;
import jpa.resources.abstracts.Resource;
import jpa.services.ListeService;
import jpa.validations.ListeValidation;


@Path("api/liste")
@Produces({"application/json", "application/xml"})
public class ListeResource extends Resource<ListeService, ListeValidation, ListeDto> {
    private ListeService listeService;

    public ListeResource() {
        super(ListeService.class, ListeValidation.class);
        listeService = new ListeService();
    }

    @GET
    @Path("/projet/{id}")
    public ResponseJpa getListByProjetId(@PathParam("id") Long id)  {
        List<ListeDto> l =  listeService.getListeByProjetId(id);
        return new ResponseJpa(Response.ok().build().getStatus(), "Succes", l);
    } 

}
