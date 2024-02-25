package com.example.s18d2.services;

import com.example.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();
    List<Vegetable> getByPriceAsc();
    Vegetable getById(long id);
    List<Vegetable> getByPriceDesc();
    Vegetable save(Vegetable vegetable);
    Vegetable delete(long id);
    List<Vegetable> searchByName(String name);
}
