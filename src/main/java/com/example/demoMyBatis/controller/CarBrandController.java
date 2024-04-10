package com.example.demoMyBatis.controller;
import com.example.demoMyBatis.dto.request.CreateCarBrandRequest;
import com.example.demoMyBatis.dto.request.UpdateCarBrandRequest;
import com.example.demoMyBatis.entity.CarBrand;
import com.example.demoMyBatis.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/brand")
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @GetMapping
    public ResponseEntity<?> findAllCarTypes(){
        return ResponseEntity.ok(carBrandService.findAllCarBrands());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findCarTypeById(@PathVariable("id") String id){
        return ResponseEntity.ok(carBrandService.findCarBrandById(id));
    }
    @PostMapping
    public ResponseEntity<?> insertCarBrand(@RequestBody CreateCarBrandRequest request){
        return ResponseEntity.ok(carBrandService.insertCarBrand(request));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCarBrand(@PathVariable("id") String id,
                                            @RequestBody UpdateCarBrandRequest request){
        return ResponseEntity.ok(carBrandService.updateCarBrand(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarBrandById(@PathVariable("id") String id){
        return ResponseEntity.ok(carBrandService.deleteCarBrandById(id));
    }
}
