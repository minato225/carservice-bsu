package com.doskoch.fpm.web5.model.carservice;

import com.doskoch.fpm.web5.model.dao.exceptions.DaoException;
import com.doskoch.fpm.web5.model.entity.*;

import java.sql.Time;
import java.util.List;

public interface ICarService {

    List<Carorder> selectAllOrderTraces();

    List<Cardriver> selectDrivers();

    List<Car> selectCars();

    void AddNewCar(int number, Brand brand, int mileage, int state) throws DaoException;

    void AddNewOrder(Brand brand, int mileage, boolean isFinished, String departure, String destination,
                     Time startTime) throws DaoException;

    Carorder selectOrdersInfoByCarDriver(String carDriverName);

    List<Car> selectBrokenCars();

    String orderCarDriver(String carDriverName, int OrderId) throws DaoException;
}
