package com.example.demoMyBatis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType {
    private int id;
    private String type;
    private String attributes;
    @JsonIgnore
    private List<Car> cars;
}
