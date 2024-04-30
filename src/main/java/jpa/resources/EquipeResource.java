package jpa.resources;

import jakarta.ws.rs.Path;
import jpa.dtos.EquipeDto;
import jpa.resources.abstracts.Resource;
import jpa.services.EquipeService;
import jpa.validations.EquipeValidation;
import jakarta.ws.rs.Produces;

@Path("api/equipe")
@Produces({"application/json", "application/xml"})
public class EquipeResource extends Resource<EquipeService, EquipeValidation, EquipeDto>{
    
    public EquipeResource() {
        super(EquipeService.class, EquipeValidation.class);
      
    }
}
