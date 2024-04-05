package com.example.demoMyBatis.repository;

import com.example.demoMyBatis.model.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarRepository {
    List<Car> findAllCar();
    Car findCarById(int id);
    Car findCarByName(String name);
    List<Car> findCarByBrand(String brandName);

    int insertCar(Car car);

    int updateCar(Car id);

    int deleteCarById(int id);


}
