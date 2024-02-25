package com.example.s18d2.controller;

import com.example.s18d2.dto.FruitDto;
import com.example.s18d2.dto.VegetableDto;
import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.Vegetable;
import com.example.s18d2.services.FruitService;
import com.example.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetable")
public class VegetableController {
    private final VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService){
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.findAll();
    }
    @GetMapping("/asc")
    public List<Vegetable> get(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Vegetable> getDesc(){
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public VegetableDto getById(@Positive @PathVariable long id){
        return new VegetableDto("succed", vegetableService.getById(id));
    }

    @PostMapping
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);

    }
    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@Size(min = 2, max = 45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable long id){
        return vegetableService.delete(id);
    }
}
