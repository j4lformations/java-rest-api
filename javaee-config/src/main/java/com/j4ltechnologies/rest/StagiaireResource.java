package com.j4ltechnologies.rest;

import com.j4ltechnologies.domain.Stagiaire;
import com.j4ltechnologies.exceptions.NotFoundException;
import com.j4ltechnologies.utils.ErrorMessage;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe StagireResource, créée le 16/06/2022 à 12:03
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
    }

    @GET
    public List<Stagiaire> stagiaires() {
        List<Stagiaire> stagiaires = new ArrayList<>(stagiaireBd.values());
        if (stagiaires.isEmpty()) {
            ErrorMessage message = new ErrorMessage(
                    "404",
                    "Aucun Stagiaire en BDD",
                    "http://localhost:8080/ws/stagiaires",
                    Response.Status.NOT_FOUND
            );
            throw new NotFoundException(message);
        }
            return stagiaires;
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
        if (courant == null) {
            ErrorMessage message = new ErrorMessage(
                    "404",
                    "Le Stagiaire d'id = " + id + " à mettre à jour est introuvable en BDD",
                    "http://localhost:8080/ws/stagiaires/" + id,
                    Response.Status.NOT_FOUND
            );
            throw new NotFoundException(message);
        }
        courant.setPrenom(stagiaire.getPrenom());
        courant.setDdn(stagiaire.getDdn());
        courant.setEmail(stagiaire.getEmail());
        stagiaireBd.put(courant.getId(), courant);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        Stagiaire courant = stagiaireBd.get(id);
        if (courant == null) {
            ErrorMessage message = new ErrorMessage(
                    "404",
                    "Le Stagiaire d'id = " + id + " à supprimer est introuvable en BDD",
                    "http://localhost:8080/ws/stagiaires/" + id,
                    Response.Status.NOT_FOUND
            );
            throw new NotFoundException(message);
        }
        stagiaireBd.remove(courant.getId());
    }
}
