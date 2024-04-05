package com.example.demoMyBatis.controller;


import com.example.demoMyBatis.model.CarType;
import com.example.demoMyBatis.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cartype")
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;

    @GetMapping
    public ResponseEntity<?> findAllCarTypes(){

        return ResponseEntity.ok(carTypeService.findAllCarTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCarTypeById(@PathVariable("id") int id){
        return ResponseEntity.ok(carTypeService.findCarTypeById(id));
    }


    @PostMapping
    public ResponseEntity<?> insertCarType(@RequestBody CarType carType){
        return ResponseEntity.ok(carTypeService.insertCarType(carType));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarType(@PathVariable("id") int id, @RequestBody CarType carType){
        return ResponseEntity.ok(carTypeService.updateCarType(id, carType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable("id") int id){
        return ResponseEntity.ok(carTypeService.deleteCarTypeById(id));
    }


}
