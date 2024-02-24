package com.example.s18d2.dao;

import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.FruitType;

import java.util.List;

public interface FruitDao {
    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Fruit findById(long id);
    Fruit update(Fruit fruit);
    Fruit remove(long id);
    List<Fruit> findByPrice(double price);
    List<Fruit> findByFruitType(FruitType fruitType);

    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    List<Fruit> searchByName(String name);


}
