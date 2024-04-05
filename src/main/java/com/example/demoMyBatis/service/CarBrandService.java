package com.example.demoMyBatis.service;

import com.example.demoMyBatis.model.Car;
import com.example.demoMyBatis.model.CarBrand;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CarBrandService {
    BaseResponse<?> findAllCarBrands();
    BaseResponse<?> findCarBrandById(int id);
    BaseResponse<?> insertCarBrand(CarBrand carBrand);
    BaseResponse<?> updateCarBrand(int id, CarBrand carBrand);
    BaseResponse<?> deleteCarBrandById(int id);
}
