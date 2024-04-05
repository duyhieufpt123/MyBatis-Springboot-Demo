package com.example.demoMyBatis.model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private int id;
    private String carName;
    private CarType carType;
    private CarBrand carBrand;
    private int carYear;

}
