package com.burakkutbay.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

/**
 * Created by Hasan Burak KUTBAY on 1/2/21.
 */
@Entity
public class Ogrenci extends PanacheEntity {

    private String name;
    private String surname;

    public Ogrenci() {
    }

    public Ogrenci(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
