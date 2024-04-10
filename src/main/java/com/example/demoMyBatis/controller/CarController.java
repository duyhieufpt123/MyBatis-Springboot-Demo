package com.example.demoMyBatis.controller;
import com.example.demoMyBatis.dto.request.CreateCarRequest;
import com.example.demoMyBatis.dto.request.UpdateCarRequest;
import com.example.demoMyBatis.entity.Car;
import com.example.demoMyBatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping
    public ResponseEntity<?> findAllCar(){
        return ResponseEntity.ok(carService.findAllCar());
    }
    @GetMapping("/brand/{brandName}")
    public ResponseEntity<?> findCarByBrand(@PathVariable("brandName") String brandName){
        return ResponseEntity.ok(carService.findCarByBrand(brandName));
    }
    @GetMapping("/carName/{carName}")
    public ResponseEntity<?> findCarByName(@PathVariable("carName") String name){
        return ResponseEntity.ok(carService.findCarByName(name));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCarById(@PathVariable("id") String id){
        return ResponseEntity.ok(carService.findCarById(id));
    }
    @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody CreateCarRequest request){
        return ResponseEntity.ok(carService.insertCar(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") String id, @RequestBody UpdateCarRequest request){
        return ResponseEntity.ok(carService.updateCar(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable("id") String id){
        return ResponseEntity.ok(carService.deleteCarById(id));
    }
}
