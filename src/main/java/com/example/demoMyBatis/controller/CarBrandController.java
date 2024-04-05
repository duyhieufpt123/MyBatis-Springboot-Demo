package com.example.demoMyBatis.controller;

import com.example.demoMyBatis.model.CarBrand;
import com.example.demoMyBatis.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/brand")
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    @GetMapping
    public ResponseEntity<?> findAllCarTypes(){
        return ResponseEntity.ok(carBrandService.findAllCarBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCarTypeById(@PathVariable("id") int id){
        return ResponseEntity.ok(carBrandService.findCarBrandById(id));
    }

    @PostMapping
    public ResponseEntity<?> insertCarBrand(@RequestBody CarBrand carBrand){
        return ResponseEntity.ok(carBrandService.insertCarBrand(carBrand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarBrand(@PathVariable("id") int id,
                                            @RequestBody CarBrand carBrand){
        return ResponseEntity.ok(carBrandService.updateCarBrand(id, carBrand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarBrandById(@PathVariable("id") int id){
        return ResponseEntity.ok(carBrandService.deleteCarBrandById(id));
    }

}
