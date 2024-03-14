package jpa.resources;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.dtos.TagDto;
import jpa.services.TagService;

import java.util.List;

@Path("tag")
@Produces({"application/json", "application/xml"})
public class TagResource {

    private TagService tagService;

    public TagResource() {
        super();
        tagService = new TagService();
    }


    @GET
    @Path("/all")
    public List<TagDto> getAlltag()  {
        List<TagDto> p =  tagService.getAll();
        return p;
    }

    @GET
    @Path("/{id}")
    public TagDto gettag(@PathParam("id") Long id)  {
        TagDto p =  tagService.get(id);
        return p;
    }

    @POST
    @Consumes("application/json")
    public Response addTag(@Parameter(description = "Pet object that needs to be added to the store", required = true) TagDto p){
        tagService.add(p);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTag (@PathParam("id") Long id){
        tagService.delete(id);
        return Response.ok().entity("SUCCESS").build();
    }
}

