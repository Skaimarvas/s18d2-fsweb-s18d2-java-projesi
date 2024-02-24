package com.example.s18d2.dao;

import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.FruitType;
import com.example.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableDao {
    Vegetable save(Vegetable vegetable);
    List<Vegetable> findAll();
    Vegetable findById(long id);
    Vegetable update(Vegetable vegetable);
    Vegetable remove(long id);
    List<Vegetable> findByPrice(double price);
    List<Vegetable> findByGrownOnTree(boolean grownOnTree);
}
