package com.example.demoMyBatis.controller;

import com.example.demoMyBatis.model.Car;
import com.example.demoMyBatis.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
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

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findCarByName(@PathVariable("name") String name){
        return ResponseEntity.ok(carService.findCarByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCarById(@PathVariable("id") int id){
        return ResponseEntity.ok(carService.findCarById(id));
    }


    @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody Car car){
        return ResponseEntity.ok(carService.insertCar(car));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") int id, @RequestBody Car car){
        return ResponseEntity.ok(carService.updateCar(id, car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable("id") int id){
        return ResponseEntity.ok(carService.deleteCarById(id));
    }


}
