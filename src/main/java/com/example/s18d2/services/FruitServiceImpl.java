package com.example.s18d2.services;

import com.example.s18d2.dao.FruitDaoImpl;
import com.example.s18d2.entity.Fruit;
import com.example.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private final FruitDaoImpl fruitDao;


    public FruitServiceImpl(FruitDaoImpl fruitDao){
        this.fruitDao = fruitDao;
    }



    @Override
    public List<Fruit> findAll(){
        return  fruitDao.findAll();
    }
    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitDao.getByPriceAsc();
    }

    @Override
    public Fruit getById(long id) {
        Optional<Fruit> optionalFruit = Optional.ofNullable(fruitDao.findById(id));

        if(optionalFruit.isPresent()){
            return optionalFruit.get();
        }
        throw new PlantException("plant with given id is not exit " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitDao.getByPriceDesc();
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitDao.save(fruit);
    }

    @Override
    public Fruit delete(long id) {
        Fruit foundFruit = getById(id);

        if(foundFruit != null){
            fruitDao.remove(id);
            return foundFruit;

        }

        return null;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitDao.searchByName(name);
    }
}
