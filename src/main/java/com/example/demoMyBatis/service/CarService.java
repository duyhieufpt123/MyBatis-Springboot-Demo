package com.example.demoMyBatis.service;

import com.example.demoMyBatis.model.Car;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    BaseResponse<?> findAllCar();
    BaseResponse<?> findCarById(int id);
    BaseResponse<?> insertCar(Car car);

    BaseResponse<?> findCarByName(String name);
    BaseResponse<?> findCarByBrand(String brandName);

    BaseResponse<?> updateCar(int id, Car car);
    BaseResponse<?> deleteCarById(int id);
}
