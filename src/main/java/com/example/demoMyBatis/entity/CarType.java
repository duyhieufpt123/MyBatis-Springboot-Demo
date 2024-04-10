package com.example.demoMyBatis.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarType {
    private String id;
    private String type;
    private String attributes;
    @JsonIgnore
    private List<Car> cars;
}
