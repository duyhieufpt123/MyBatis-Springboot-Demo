package com.example.demoMyBatis.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String id;
    private String carName;
    private CarType carType;
    private CarBrand carBrand;
    private int carYear;
}
