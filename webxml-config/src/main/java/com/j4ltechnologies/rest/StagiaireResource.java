package com.j4ltechnologies.rest;

import com.j4ltechnologies.rest.domain.Stagiaire;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Stagiaire create(Stagiaire stagiaire) {
        stagiaire.setId(stagiaireId.incrementAndGet());
        stagiaireBd.put(stagiaire.getId(), stagiaire);
        return stagiaire;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Stagiaire read(@PathParam("id") Integer id){
        return stagiaireBd.get(id);
    }
}
