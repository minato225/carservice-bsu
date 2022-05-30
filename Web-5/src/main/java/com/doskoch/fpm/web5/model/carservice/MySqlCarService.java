package com.doskoch.fpm.web5.model.carservice;

import com.doskoch.fpm.web5.model.entity.*;
import com.doskoch.fpm.web5.model.dao.DaoOrder;
import com.doskoch.fpm.web5.model.dao.DaoCarDriver;
import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;

import java.sql.Time;
import java.util.List;

public class MySqlCarService implements ICarService {
    private final DaoOrder daoOrder = new DaoOrder();
    private final DaoCarDriver daoCarDriver = new DaoCarDriver();

    @Override
    public List<Carorder> selectAllOrderTraces() {
        return daoOrder.selectAllOrderTraces();
    }

    @Override
    public List<Cardriver> selectDrivers() {
        return daoCarDriver.selectDrivers();
    }

    @Override
    public List<Car> selectCars() {
        return daoCarDriver.selectCars();
    }

    @Override
    public void AddNewCar(int number, Brand brand, int mileage, int state) throws DaoException {
        var car = new Car(number, brand.name(), mileage, (byte) state);
        daoCarDriver.addNewDCar(car);
    }

    @Override
    public void AddNewOrder(Brand brand, int mileage, boolean isFinished, String departure, String destination, Time startTime) throws DaoException {
        var b = isFinished ? 1 : 0;
        var order = new Carorder(brand.name(), mileage, (byte) b, departure, destination, startTime);
        daoOrder.addNewOrder(order);
    }

    @Override
    public Carorder selectOrdersInfoByCarDriver(String carDriverName) {
        return daoOrder.selectOrdersInfoByCarDriver(carDriverName);
    }

    @Override
    public List<Car> selectBrokenCars() {
        return daoCarDriver.selectBrokenCars();
    }

    @Override
    public String orderCarDriver(String carDriverName, int orderId) throws DaoException {
        return daoOrder.orderCarDriver(carDriverName, orderId);
    }
}
