package com.example.demoMyBatis.repository;
import com.example.demoMyBatis.entity.CarBrand;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.UUID;

@Mapper
public interface CarBrandRepository {
    List<CarBrand> findAllCarBrands();
    CarBrand findCarBrandById(String id);
    CarBrand findCarBrandByName(String brandName);
    int insertCarBrand(CarBrand carBrand);
    int updateCarBrand(CarBrand carBrand);
    void deleteCarBrandById(String id);
}
