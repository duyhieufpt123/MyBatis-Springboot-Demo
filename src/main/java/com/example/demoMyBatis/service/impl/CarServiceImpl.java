package com.example.demoMyBatis.service.impl;
import com.example.demoMyBatis.constant.RES_CODE;
import com.example.demoMyBatis.dto.request.CreateCarRequest;
import com.example.demoMyBatis.dto.request.UpdateCarRequest;
import com.example.demoMyBatis.dto.response.CarResponse;
import com.example.demoMyBatis.entity.Car;
import com.example.demoMyBatis.entity.CarBrand;
import com.example.demoMyBatis.entity.CarType;
import com.example.demoMyBatis.repository.CarBrandRepository;
import com.example.demoMyBatis.repository.CarRepository;
import com.example.demoMyBatis.repository.CarTypeRepository;
import com.example.demoMyBatis.response.BaseResponse;
import com.example.demoMyBatis.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarBrandRepository carBrandRepository;
    @Autowired
    private CarTypeRepository carTypeRepository;
    @Override
    public BaseResponse<List<CarResponse>> findAllCar() {
        BaseResponse<List<CarResponse>> response = new BaseResponse<>();
        List<CarResponse> cars = carRepository.findAllCar();
        if (cars.isEmpty()){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(cars);
        }
        return response;
    }
    @Override
    public BaseResponse<?> findCarById(String id) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car car = carRepository.findCarById(id);
        if (car == null){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(car);
        }
        return response;
    }
    @Override
    public BaseResponse<?> insertCar(CreateCarRequest request) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car existCar = carRepository.findCarByName(request.carName());
        CarBrand carBrand = carBrandRepository.findCarBrandById(request.carBrandId());
        if (carBrand == null) {
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Brand not found");
            response.setData(null);
        }
        CarType carType = carTypeRepository.findCarTypeById(request.carTypeId());
        if (carType == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Type not found");
            response.setData(null);
        }
        if (existCar != null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car already exist with name: "+request.carName());
            response.setData(null);
            return response;
        }
        try {
            Car car = new Car();
            car.setId(UUID.randomUUID().toString());
            car.setCarName(request.carName());
            car.setCarBrand(carBrand);
            car.setCarType(carType);
            car.setCarYear(request.carYear());
            carRepository.insertCar(car);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(car);
        } catch (Exception e){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car create fail: "+e.getMessage());
        }
        return response;
    }
    @Override
    public BaseResponse<?> findCarByName(String name) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car car = carRepository.findCarByName(name);
        if (car == null){
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else{
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(car);
        }
        return response;
    }
    @Override
    public BaseResponse<?> findCarByBrand(String brandName) {
        BaseResponse<List<Car>> response = new BaseResponse<>();
        List<Car> cars = carRepository.findCarByBrand(brandName);
        if (cars.isEmpty()) {
            response.setCode(RES_CODE.EMPTY.getCode());
            response.setMessage(RES_CODE.EMPTY.getMessage());
            response.setData(null);
        } else {
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage(RES_CODE.SUCCESS.getMessage());
            response.setData(cars);
        }
        return response;
    }
    @Override
    public BaseResponse<?> updateCar(String id, UpdateCarRequest request) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car findCar = carRepository.findCarById(id);
        CarBrand carBrand = carBrandRepository.findCarBrandById(request.carBrandId());
        if (carBrand == null) {
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Brand not found");
            response.setData(null);
        }
        CarType carType = carTypeRepository.findCarTypeById(request.carTypeId());
        if (carType == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Type not found");
            response.setData(null);
        }
        if(findCar == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car not found");
            response.setData(null);
        }
        else {
            findCar.setCarName(request.carName());
            findCar.setCarBrand(carBrand);
            findCar.setCarType(carType);
            findCar.setCarYear(request.carYear());
            int savedCar = carRepository.updateCar(findCar);
            if (savedCar > 0 ){
                response.setCode(RES_CODE.SUCCESS.getCode());
                response.setMessage(RES_CODE.SUCCESS.getMessage());
                response.setData(findCar);
            } else {
                response.setCode(RES_CODE.FAIL.getCode());
                response.setMessage(RES_CODE.FAIL.getMessage());
                response.setData(null);
            }
        }
        return response;
    }
    @Override
    public BaseResponse<?> deleteCarById(String id) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car car = carRepository.findCarById(id);
        if (car == null){
            response.setCode(RES_CODE.FAIL.getCode());
            response.setMessage("Car not found");
            response.setData(null);
        } else {
            carRepository.deleteCarById(id);
            response.setCode(RES_CODE.SUCCESS.getCode());
            response.setMessage("Deleted Successfully");
            response.setData(null);
        }
        return response;
    }
}