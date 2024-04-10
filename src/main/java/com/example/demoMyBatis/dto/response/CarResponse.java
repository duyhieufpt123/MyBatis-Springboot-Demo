package com.example.demoMyBatis.dto.response;

import com.example.demoMyBatis.entity.CarBrand;
import com.example.demoMyBatis.entity.CarType;

import java.util.UUID;

public record CarResponse(UUID id, String carName, CarType carType, CarBrand carBrand, int carYear) {
}
