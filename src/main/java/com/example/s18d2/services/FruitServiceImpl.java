package com.example.s18d2.services;

import com.example.s18d2.dao.FruitDaoImpl;
import com.example.s18d2.entity.Fruit;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private final FruitDaoImpl fruitDao;


    public FruitServiceImpl(FruitDaoImpl fruitDao){
        this.fruitDao = fruitDao;
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return null;
    }

    @Override
    public Fruit getById(long id) {
        return null;
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return null;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return null;
    }

    @Override
    public Fruit delete(long id) {
        return null;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return null;
    }
}
