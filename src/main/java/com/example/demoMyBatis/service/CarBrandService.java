package com.example.demoMyBatis.service;
import com.example.demoMyBatis.dto.request.CreateCarBrandRequest;
import com.example.demoMyBatis.dto.request.UpdateCarBrandRequest;
import com.example.demoMyBatis.entity.CarBrand;
import com.example.demoMyBatis.response.BaseResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CarBrandService {
    BaseResponse<?> findAllCarBrands();
    BaseResponse<?> findCarBrandById(String id);
    BaseResponse<?> insertCarBrand(CreateCarBrandRequest request);
    BaseResponse<?> updateCarBrand(String id, UpdateCarBrandRequest request);
    BaseResponse<?> deleteCarBrandById(String id);
}
