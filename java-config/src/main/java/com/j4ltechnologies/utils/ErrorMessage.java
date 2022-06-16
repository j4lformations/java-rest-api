package com.j4ltechnologies.utils;

import static jakarta.ws.rs.core.Response.Status;

/**
 * Classe ErrorMessage, créée le 16/06/2022 à 11:49
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
public class ErrorMessage {
    private String code;
    private String description;
    private String uri;
    private Status status;

    public ErrorMessage(String code, String description, String uri, Status status) {
        this.code = code;
        this.description = description;
        this.uri = uri;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
