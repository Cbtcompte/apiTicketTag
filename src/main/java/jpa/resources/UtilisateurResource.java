package jpa.resources;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jpa.dtos.UtilisateurDto;
import jpa.resources.abstracts.Resource;
import jpa.services.UtilisateurService;
import jpa.validations.UtilisateurValidation;


@Path("/api/utilisateur")
@Produces({"application/json", "application/xml"})
public class UtilisateurResource extends Resource<UtilisateurService, UtilisateurValidation, UtilisateurDto>{

    public UtilisateurResource() {
        super(UtilisateurService.class, UtilisateurValidation.class);
    }
}

