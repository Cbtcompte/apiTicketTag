package jpa.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jpa.dtos.ListeDto;
import jpa.resources.abstracts.Resource;
import jpa.services.ListeService;
import jpa.validations.ListeValidation;


@Path("liste")
@Produces({"application/json", "application/xml"})
public class ListeResource extends Resource<ListeService, ListeValidation, ListeDto> {


    public ListeResource() {
        super(ListeService.class, ListeValidation.class);
      
    }

}
