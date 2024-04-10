package com.example.demoMyBatis.service.impl;
import com.example.demoMyBatis.constant.RES_CODE;
import com.example.demoMyBatis.dto.request.CreateCarTypeRequest;
import com.example.demoMyBatis.dto.request.UpdateCarTypeRequest;
import com.example.demoMyBatis.entity.CarType;
import com.example.demoMyBatis.repository.CarTypeRepository;
import com.example.demoMyBatis.response.BaseResponse;
import com.example.demoMyBatis.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarTypeServiceImpl implements CarTypeService {
    @Autowired
    private CarTypeRepository carTypeRepository;
    @Override
    public BaseResponse<?> findAllCarTypes() {
        BaseResponse<List<CarType>> response = new BaseResponse<>();
        List<CarType> carTypes = carTypeRepository.findAllCarTypes();
        if (carTypes.isEmpty()){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carTypes);
        }
        return response;
    }
    @Override
    public BaseResponse<?> findCarTypeById(String id) {
        BaseResponse<CarType> response = new BaseResponse<>();
        CarType carType = carTypeRepository.findCarTypeById(id);
        if (carType == null){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carType);
        }
        return response;
    }
    @Override
    public BaseResponse<?> insertCarType(CreateCarTypeRequest request) {
        BaseResponse<CarType> response = new BaseResponse<>();
        try {
            CarType existCarType = carTypeRepository.findCarTypeByTypeName(request.type());
            if (existCarType != null){
                response.setCode(RES_CODE.FAIL.getCode());
                response.setMessage("CarType already exist with name: "+request.type());
                return response;
            }
            CarType carType = new CarType();
            carType.setId(UUID.randomUUID().toString());
            carType.setType(request.type());
            carType.setAttributes(request.attributes());
            carTypeRepository.insertCarType(carType);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carType);
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(RES_CODE.FAIL.getCode());
            String errorMessage = e.getMessage() == null ? "Unknown error" : e.getMessage();
            response.setMessage("Car Type create fail: " + errorMessage);
        }
        return response;
    }
    @Override
    public BaseResponse<?> updateCarType(String id, UpdateCarTypeRequest request) {
        BaseResponse<CarType> response = new BaseResponse<>();
        CarType existingCarType = carTypeRepository.findCarTypeById(id);
        if (existingCarType == null) {
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("CarType not found");
            response.setData(null);
        } else {
            existingCarType.setType(request.type());
            existingCarType.setAttributes(request.attributes());
            int updateCount = carTypeRepository.updateCarType(existingCarType);
            if (updateCount > 0) {
                response.setCode(RES_CODE.SUCCESS.getCode());
                response.setMessage(RES_CODE.SUCCESS.getMessage());
                response.setData(existingCarType);
            } else {
                response.setCode(RES_CODE.FAIL.getCode());
                response.setMessage("Update failed");
                response.setData(null);
            }
        }
        return response;
    }
    @Override
    public BaseResponse<?> deleteCarTypeById(String id) {
        BaseResponse<CarType> response = new BaseResponse<>();
        CarType carType = carTypeRepository.findCarTypeById(id);
        if (carType == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car not found");
            response.setData(null);
        } else {
            carTypeRepository.deleteCarTypeById(id);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage("Deleted Successfully");
            response.setData(null);
        }
        return response;
    }
}