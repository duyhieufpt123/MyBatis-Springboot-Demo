package com.example.demoMyBatis.service.impl;
import com.example.demoMyBatis.constant.RES_CODE;
import com.example.demoMyBatis.dto.request.CreateCarBrandRequest;
import com.example.demoMyBatis.dto.request.UpdateCarBrandRequest;
import com.example.demoMyBatis.entity.CarBrand;
import com.example.demoMyBatis.repository.CarBrandRepository;
import com.example.demoMyBatis.response.BaseResponse;
import com.example.demoMyBatis.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarBrandServiceImpl implements CarBrandService {
    @Autowired
    private CarBrandRepository carBrandRepository;

    public CarBrandServiceImpl(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }
    @Override
    public BaseResponse<?> findAllCarBrands() {
        BaseResponse<List<CarBrand>> response = new BaseResponse<>();
        List<CarBrand> carBrands = carBrandRepository.findAllCarBrands();
        if (carBrands.isEmpty()){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carBrands);
        }
        return response;
    }
    @Override
    public BaseResponse<?> findCarBrandById(String id) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand carBrand = carBrandRepository.findCarBrandById(id);
        if (carBrand == null){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carBrand);
        }
        return response;
    }
    @Override
    public BaseResponse<?> insertCarBrand(CreateCarBrandRequest request) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand existCarBrand = carBrandRepository.findCarBrandByName(request.name());
        if (existCarBrand != null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car Brand already exist with name: "+request.name());
            response.setData(null);
            return response;
        }
        try {
            CarBrand carBrand = new CarBrand();
            carBrand.setId(UUID.randomUUID().toString());
            carBrand.setName(request.name());
            carBrandRepository.insertCarBrand(carBrand);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carBrand);
        } catch (Exception e){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car create fail: "+e.getMessage());
        }
        return response;
    }
    @Override
    public BaseResponse<?> updateCarBrand(String id, UpdateCarBrandRequest request) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand findCarBrand = carBrandRepository.findCarBrandById(id);
        if(findCarBrand == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car brand not found");
            response.setData(null);
        } else {
            findCarBrand.setName(request.name());
            int savedCarBrand = carBrandRepository.updateCarBrand(findCarBrand);
            if(savedCarBrand > 0 ){
                response.setCode(RES_CODE.SUCCESS.getCode());
                response.setMessage(RES_CODE.SUCCESS.getMessage());
                response.setData(findCarBrand);
            }
        }
        return response;
    }
    @Override
    public BaseResponse<?> deleteCarBrandById(String id) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand carBrand = carBrandRepository.findCarBrandById(id);
        if (carBrand == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car not found");
            response.setData(null);
        } else {
            carBrandRepository.deleteCarBrandById(id);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage("Deleted Successfully");
            response.setData(null);
        }
        return response;
    }
}