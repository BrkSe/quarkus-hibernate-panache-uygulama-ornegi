package com.burakkutbay.service;

import com.burakkutbay.model.Ogrenci;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Hasan Burak KUTBAY on 1/2/21.
 */
@Path("ogrenci")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OgrenciService {

    @POST
    @Transactional
    public Response save(Ogrenci ogrenci) {
        ogrenci.persist();
        return Response.ok(ogrenci).status(201).build();
    }

    @GET
    public List<Ogrenci> get() {
        return Ogrenci.listAll();
        //return Ogrenci.listAll(Sort.by("name"));
    }

    @GET
    @Path("{id}")
    public Ogrenci getSingle(@PathParam("id") Long id) {
        Ogrenci ogr = Ogrenci.findById(id);
        if (ogr == null) {
            throw new WebApplicationException(id + " bulunamadı", 404);
        }
        return ogr;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Ogrenci update(@PathParam("id") Long id, Ogrenci ogrenci) {
        Ogrenci ogr = Ogrenci.findById(id);
        ogr.setName(ogrenci.getName());
        return ogr;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Ogrenci ogrdelete = Ogrenci.findById(id);
        ogrdelete.delete();
        return Response.status(200).build();
    }

}
