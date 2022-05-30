package com.doskoch.fpm.web5.model.dao;

import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.function.Consumer;

public class DaoUser extends Dao {
    public void save(User user) throws DaoException {
        executeInsideTransaction(m -> m.persist(user));
    }
    private void executeInsideTransaction(Consumer<EntityManager> action) throws DaoException {
        EntityManager manager = null;
        EntityTransaction transaction = null;
        try {
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            action.accept(manager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DaoException("failed to add new user", e);
        } finally {
            if (manager != null && manager.isOpen())
                manager.close();
        }
    }

    @Override
    public void close() throws Exception {
    }
}
