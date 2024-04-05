package com.example.demoMyBatis.service.impl;

import com.example.demoMyBatis.constant.RES_CODE;
import com.example.demoMyBatis.model.CarBrand;
import com.example.demoMyBatis.repository.CarBrandRepository;
import com.example.demoMyBatis.response.BaseResponse;
import com.example.demoMyBatis.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;

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
    public BaseResponse<?> findCarBrandById(int id) {
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
    public BaseResponse<?> insertCarBrand(CarBrand carBrand) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand existCarBrand = carBrandRepository.findCarBrandByName(carBrand.getName());
        if (existCarBrand != null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car Brand already exist with name: "+carBrand.getName());
            response.setData(null);

            return response;
        }
        try {
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
    public BaseResponse<?> updateCarBrand(int id, CarBrand carBrand) {
        BaseResponse<CarBrand> response = new BaseResponse<>();
        CarBrand findCarBrand = carBrandRepository.findCarBrandById(id);
        if(findCarBrand == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car not found");
            response.setData(null);
        } else {
            findCarBrand.setName(carBrand.getName());

            carBrandRepository.updateCarBrand(carBrand);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(carBrand);

        }
        return response;
    }

    @Override
    public BaseResponse<?> deleteCarBrandById(int id) {
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


