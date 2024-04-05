package com.example.demoMyBatis.repository;


import com.example.demoMyBatis.model.CarType;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CarTypeRepository {
    List<CarType> findAllCarTypes();
    CarType findCarTypeById(int id);
    CarType findCarTypeByTypeName(String typeName);
    int insertCarType(CarType carType);
    int updateCarType(CarType carType);
    void deleteCarTypeById(int id);
}
