package com.example.demoMyBatis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand {
    private int id;
    private String name;
    @JsonIgnore
    private int year;
    @JsonIgnore
    private List<Car> cars;
}
