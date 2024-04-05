package com.example.demoMyBatis.service.impl;

import com.example.demoMyBatis.constant.RES_CODE;
import com.example.demoMyBatis.model.Car;
import com.example.demoMyBatis.model.CarType;
import com.example.demoMyBatis.repository.CarTypeRepository;
import com.example.demoMyBatis.response.BaseResponse;
import com.example.demoMyBatis.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public BaseResponse<?> findCarTypeById(int id) {
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
    public BaseResponse<?> insertCarType(CarType carType) {
        BaseResponse<CarType> response = new BaseResponse<>();
        try {
            CarType existCarType = carTypeRepository.findCarTypeByTypeName(carType.getType());
            if (existCarType != null){
                response.setCode(RES_CODE.FAIL.getCode());
                response.setMessage("CarType already exist with name: "+carType.getType());
                return response;
            }

            carTypeRepository.insertCarType(carType);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carType);
        } catch (Exception e) {
            e.printStackTrace(); // Log the stack trace for debugging
            response.setCode(RES_CODE.FAIL.getCode());
            String errorMessage = e.getMessage() == null ? "Unknown error" : e.getMessage();
            response.setMessage("Car create fail: " + errorMessage);
        }
        return response;
    }


    @Override
    public BaseResponse<?> updateCarType(int id, CarType carType) {
        BaseResponse<CarType> response = new BaseResponse<>();
        CarType existingCarType = carTypeRepository.findCarTypeById(id);
        if (existingCarType == null) {
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("CarType not found");
            response.setData(null);
        } else {
            existingCarType.setType(carType.getType());
            existingCarType.setAttributes(carType.getAttributes());

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
    public BaseResponse<?> deleteCarTypeById(int id) {
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
