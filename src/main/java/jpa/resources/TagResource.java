package jpa.resources;


import jpa.resources.abstracts.Resource;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jpa.dtos.TagDto;
import jpa.services.TagService;
import jpa.validations.TagValidation;


@Path("tag")
@Produces({"application/json", "application/xml"})
public class TagResource extends Resource<TagService, TagValidation, TagDto> {

    public TagResource() {
        super(TagService.class, TagValidation.class);
    }
}

