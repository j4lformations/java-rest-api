package com.j4ltechnologies.exceptions;

import com.j4ltechnologies.utils.ErrorMessage;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Classe NotFoundException, créée le 16/06/2022 à 11:58
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
public class NotFoundException extends WebApplicationException {
    public NotFoundException(ErrorMessage message) {
        super(
                Response
                        .status(Response.Status.NOT_FOUND)
                        .entity(message)
                        .type(MediaType.APPLICATION_JSON_TYPE)
                        .build()
        );
    }
}
