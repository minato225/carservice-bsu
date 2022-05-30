package com.doskoch.fpm.web5.model.dao;

import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.Car;
import com.doskoch.fpm.web5.model.entity.Cardriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DaoCarDriver extends Dao {

    private static final Logger logger = LogManager.getLogger();

    public List<Car> selectBrokenCars() {
        List<Car> cars;
        EntityManager manager = null;
        try {
            manager = factory.createEntityManager();
            cars = manager
                    .createNamedQuery("Car.SelectBrokenCars", Car.class)
                    .getResultList();
            logger.info("Broken cars was selected");
        } finally {
            if (manager != null && manager.isOpen())
                manager.close();
        }
        return cars;
    }

    public List<Car> selectCars() {
        List<Car> cars;
        EntityManager manager = null;
        try {
            manager = factory.createEntityManager();
            cars = manager
                    .createNamedQuery("Car.SelectCars", Car.class)
                    .getResultList();

            logger.info("Broken cars was selected");
        } finally {
            if (manager != null && manager.isOpen())
                manager.close();
        }
        return cars;
    }

    public List<Cardriver> selectDrivers() {
        List<Cardriver> drivers;
        EntityManager manager = null;
        try {
            manager = factory.createEntityManager();
            drivers = manager
                    .createNamedQuery("Cardriver.SelectCardrivers", Cardriver.class)
                    .getResultList();

            logger.info("CarDrivers was selected");
        } finally {
            if (manager != null && manager.isOpen())
                manager.close();
        }
        return drivers;
    }

    public void addNewDCar(Car car) throws DaoException {
        EntityManager manager = null;
        EntityTransaction transaction = null;
        try {
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();

            transaction.begin();
            manager.persist(car);
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
