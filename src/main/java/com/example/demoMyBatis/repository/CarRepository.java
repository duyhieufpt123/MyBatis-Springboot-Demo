package com.example.demoMyBatis.repository;
import com.example.demoMyBatis.dto.response.CarResponse;
import com.example.demoMyBatis.entity.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarRepository {
    List<CarResponse> findAllCar();
    Car findCarById(String id);
    Car findCarByName(String name);
    List<Car> findCarByBrand(String brandName);
    int insertCar(Car car);
    int updateCar(Car car);
    int deleteCarById(String id);
}
