package jpa.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jpa.dtos.ProjetDto;
import jpa.resources.abstracts.Resource;
import jpa.services.ProjetService;
import jpa.validations.ProjetValidation;


@Path("projet")
@Produces({"application/json", "application/xml"})
public class ProjetResource extends Resource<ProjetService, ProjetValidation, ProjetDto> {
    public ProjetResource() {
        super(ProjetService.class, ProjetValidation.class);
      
    }

}
