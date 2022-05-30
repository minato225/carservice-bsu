package com.doskoch.fpm.web5.model.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Dao implements AutoCloseable {

    protected EntityManagerFactory factory;

    public Dao() {
        this.factory = Persistence.createEntityManagerFactory("default");
    }
}
