package com.example.s18d2.services;

import com.example.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getByPriceAsc();
    Fruit getById(long id);
    List<Fruit> getByPriceDesc();
    Fruit save(Fruit fruit);
    Fruit delete(long id);
    List<Fruit> searchByName(String name);

}
