package com.example.demoMyBatis.service;

import com.example.demoMyBatis.model.CarType;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

@Service
public interface CarTypeService {
    BaseResponse<?> findAllCarTypes();
    BaseResponse<?> findCarTypeById(int id);
    BaseResponse<?> insertCarType(CarType carType);
    BaseResponse<?> updateCarType(int id, CarType carType);
    BaseResponse<?> deleteCarTypeById(int id);

}
