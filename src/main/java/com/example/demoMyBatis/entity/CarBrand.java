package com.example.demoMyBatis.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarBrand {
    private String id;
    private String name;
    @JsonIgnore
    private int year;
    @JsonIgnore
    private List<Car> cars;
}
