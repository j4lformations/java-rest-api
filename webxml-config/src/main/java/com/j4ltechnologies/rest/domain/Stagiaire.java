package com.j4ltechnologies.rest.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Classe Stagiaire, créée le 16/06/2022 à 10:34
 *
 * @author Joachim Zadi
 * @version 1.0 du 16/06/2022
 */
@XmlRootElement(name = "stagiaire")
@XmlAccessorType(XmlAccessType.FIELD)
public class Stagiaire {
    @XmlElement
    private Integer id;
    @XmlElement
    private String prenom;
    @XmlElement
    private int age;
    @XmlElement
    private String email;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
