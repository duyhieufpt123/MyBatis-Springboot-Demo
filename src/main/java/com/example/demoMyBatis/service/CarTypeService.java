package com.example.demoMyBatis.service;
import com.example.demoMyBatis.dto.request.CreateCarTypeRequest;
import com.example.demoMyBatis.dto.request.UpdateCarTypeRequest;
import com.example.demoMyBatis.entity.CarType;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CarTypeService {
    BaseResponse<?> findAllCarTypes();
    BaseResponse<?> findCarTypeById(String id);
    BaseResponse<?> insertCarType(CreateCarTypeRequest request);
    BaseResponse<?> updateCarType(String id, UpdateCarTypeRequest request);
    BaseResponse<?> deleteCarTypeById(String id);
}
