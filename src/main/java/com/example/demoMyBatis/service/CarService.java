package com.example.demoMyBatis.service;
import com.example.demoMyBatis.dto.request.CreateCarRequest;
import com.example.demoMyBatis.dto.request.UpdateCarRequest;
import com.example.demoMyBatis.dto.response.CarResponse;
import com.example.demoMyBatis.entity.Car;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CarService {
    BaseResponse<List<CarResponse>> findAllCar();
    BaseResponse<?> findCarById(String id);
    BaseResponse<?> insertCar(CreateCarRequest request);
    BaseResponse<?> findCarByName(String name);
    BaseResponse<?> findCarByBrand(String brandName);
    BaseResponse<?> updateCar(String id, UpdateCarRequest request);
    BaseResponse<?> deleteCarById(String id);
}
