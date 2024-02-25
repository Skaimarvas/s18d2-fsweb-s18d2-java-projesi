package com.example.s18d2.services;


import com.example.s18d2.dao.FruitDaoImpl;
import com.example.s18d2.dao.VegetableDaoImpl;
import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.Vegetable;
import com.example.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private final VegetableDaoImpl vegetableDao;


    public VegetableServiceImpl(VegetableDaoImpl vegetableDao){
        this.vegetableDao = vegetableDao;
    }

    @Override
    public List<Vegetable> findAll(){
        return  vegetableDao.findAll();
    }
    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableDao.getByPriceAsc();
    }

    @Override
    public Vegetable getById(long id) {
        Optional<Vegetable> optionalVegetable = Optional.ofNullable(vegetableDao.findById(id));

        if(optionalVegetable.isPresent()){
            return optionalVegetable.get();
        }
        throw new PlantException("Plant with given id is not exit " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableDao.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableDao.save(vegetable);
    }

    @Override
    public Vegetable delete(long id) {
        Vegetable foundVegetable = getById(id);

        if(foundVegetable != null){
            vegetableDao.remove(id);
            return foundVegetable;

        }

        return null;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableDao.searchByName(name);
    }
}
