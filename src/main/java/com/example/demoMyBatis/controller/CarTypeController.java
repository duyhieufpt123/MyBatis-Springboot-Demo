package com.example.demoMyBatis.controller;
import com.example.demoMyBatis.dto.request.CreateCarTypeRequest;
import com.example.demoMyBatis.dto.request.UpdateCarTypeRequest;
import com.example.demoMyBatis.entity.CarType;
import com.example.demoMyBatis.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cartype")
public class CarTypeController {
    @Autowired
    private CarTypeService carTypeService;
    @GetMapping
    public ResponseEntity<?> findAllCarTypes(){

        return ResponseEntity.ok(carTypeService.findAllCarTypes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCarTypeById(@PathVariable("id") String id){
        return ResponseEntity.ok(carTypeService.findCarTypeById(id));
    }
    @PostMapping
    public ResponseEntity<?> insertCarType(@RequestBody CreateCarTypeRequest request){
        return ResponseEntity.ok(carTypeService.insertCarType(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarType(@PathVariable("id") String id, @RequestBody UpdateCarTypeRequest request){
        return ResponseEntity.ok(carTypeService.updateCarType(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable("id") String id){
        return ResponseEntity.ok(carTypeService.deleteCarTypeById(id));
    }
}
