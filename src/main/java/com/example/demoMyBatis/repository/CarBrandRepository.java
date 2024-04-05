package com.example.demoMyBatis.repository;


import com.example.demoMyBatis.model.CarBrand;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CarBrandRepository {
    List<CarBrand> findAllCarBrands();
    CarBrand findCarBrandById(int id);

    CarBrand findCarBrandByName(String brandName);
    int insertCarBrand(CarBrand carBrand);
    int updateCarBrand(CarBrand carBrand);
    void deleteCarBrandById(int id);
}
