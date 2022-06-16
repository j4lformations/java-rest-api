package com.j4ltechnologies.rest;

import com.j4ltechnologies.rest.domain.Stagiaire;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe StagiaireResource, créée le 16/06/2022 à 10:38
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
@Path("stagiaires")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class StagiaireResource {
    private static final Map<Integer, Stagiaire> stagiaireBd;
    private static final AtomicInteger stagiaireId;

    static {
        stagiaireBd = new ConcurrentHashMap<>();
        stagiaireId = new AtomicInteger();

        Stagiaire kim = new Stagiaire();
        kim.setId(stagiaireId.incrementAndGet());
        kim.setPrenom("Kim");
        kim.setAge(53);
        kim.setEmail("kim@m2i.fr");
        stagiaireBd.put(kim.getId(), kim);

        Stagiaire ange = new Stagiaire();
        ange.setId(stagiaireId.incrementAndGet());
        ange.setPrenom("Ange");
        ange.setAge(53);
        ange.setEmail("ange@m2i.fr");
        stagiaireBd.put(ange.getId(), ange);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stagiaire> stagiaires() {
        return new ArrayList<>(stagiaireBd.values());
    }

    @POST
    public Stagiaire create(Stagiaire stagiaire) {
        stagiaire.setId(stagiaireId.incrementAndGet());
        stagiaireBd.put(stagiaire.getId(), stagiaire);
        return stagiaire;
    }

    @GET
    @Path("{id}")
    public Stagiaire read(@PathParam("id") Integer id) {
        return stagiaireBd.get(id);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Integer id, Stagiaire stagiaire) {
        Stagiaire courant = stagiaireBd.get(id);
        courant.setPrenom(stagiaire.getPrenom());
        courant.setAge(stagiaire.getAge());
        courant.setEmail(stagiaire.getEmail());
        stagiaireBd.put(courant.getId(), courant);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        Stagiaire courant = stagiaireBd.remove(id);
        if (courant == null)
            throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
}
