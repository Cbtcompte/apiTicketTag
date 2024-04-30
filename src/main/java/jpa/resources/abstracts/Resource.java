package jpa.resources.abstracts;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jpa.ResponseJpa;
import jpa.services.interfaces.Service;
import jpa.validations.abstracts.Validation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Resource<S, V, D> {

    protected Service<D> s;
    private Validation<D> v;

    public Resource( Class<S> typeS, Class<V> typeV) {
        try {
            this.s =(Service) typeS.getDeclaredConstructor().newInstance();
            this.v = (Validation) typeV.getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException | InstantiationException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }



    @GET
    @Path("/all")
    public ResponseJpa getAll()  {
        List<D> l =  s.getAll();
        return new ResponseJpa(Response.ok().build().getStatus(), "Succes", l);
    }

    @GET
    @Path("/{id}")
    public ResponseJpa get(@PathParam("id") Long id)  {
        D l =  s.get(id);
       return new ResponseJpa(Response.ok().build().getStatus(), "Succes", l);
    }

    @POST
    @Path("/create")
    @Consumes("application/json")
    public ResponseJpa add(@Parameter(description = "Pet object that needs to be added to the store", required = true) D d){
        v.rules(d);
        if(v.isError()){
            return new ResponseJpa(Response.status(402).build().getStatus(), "Les données ne sont pas correctes", v.getMessages());
        }
        try {
            d = s.add(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseJpa(Response.status(200).build().getStatus(), "Success", d);
    }

    @DELETE
    @Path("delete/{id}")
    public ResponseJpa deleteListe (@PathParam("id") Long id){
        s.delete(id);
        return new ResponseJpa(Response.status(200).build().getStatus(), "Success", s.getAll());
    }

    @PUT
    @Path("update/{id}")
    @Consumes("application/json")
    public ResponseJpa put(@Parameter(description = "Pet object that needs to be added to the store", required = true) D d, @PathParam("id") Long id){
        v.rules(d);
        if(v.isError()){
            return new ResponseJpa(Response.status(402).build().getStatus(), "Les données ne sont pas correctes", v.getMessages());
        }
        try {
            d = s.update(d, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseJpa(Response.status(200).build().getStatus(), "Success", d);
    }
}
