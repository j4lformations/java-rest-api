package com.j4ltechnologies.domain;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.json.bind.annotation.JsonbTransient;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe Stagiaire, créée le 16/06/2022 à 11:44
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
@JsonbPropertyOrder({"id", "prenom", "ddn", "email"})
public class Stagiaire {
    private Integer id;
    private String prenom;
    private String email;

    @JsonbProperty("dateNaissance")
    @JsonbDateFormat(locale = "fr_FR", value = "dd-MM-yyyy")
    private LocalDate ddn;
    private int age;

    public Stagiaire() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDdn() {
        return ddn;
    }

    public void setDdn(LocalDate ddn) {
        this.ddn = ddn;
    }

    public int getAge() {
        Period age = Period.between(ddn, LocalDate.now());
        return age.getYears();
    }
}
