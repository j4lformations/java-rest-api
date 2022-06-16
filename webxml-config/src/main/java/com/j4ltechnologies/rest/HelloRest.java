package com.j4ltechnologies.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Classe HelloRest, créée le 16/06/2022 à 10:21
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
@Path("hello")
public class HelloRest {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String disBonjour(){
        return "Bonjour Depuis le service REST";
    }
}
