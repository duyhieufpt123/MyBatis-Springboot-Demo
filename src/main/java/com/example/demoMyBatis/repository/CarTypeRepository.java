package com.example.demoMyBatis.repository;
import com.example.demoMyBatis.entity.CarType;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CarTypeRepository {
    List<CarType> findAllCarTypes();
    CarType findCarTypeById(String id);
    CarType findCarTypeByTypeName(String typeName);
    int insertCarType(CarType carType);
    int updateCarType(CarType carType);
    void deleteCarTypeById(String id);
}
