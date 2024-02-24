package com.example.s18d2.dao;

import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.FruitType;
import com.example.s18d2.exceptions.PlantException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitDaoImpl implements FruitDao{
    private final EntityManager entityManager;

    @Autowired
    public FruitDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Fruit save(Fruit fruit) {
        entityManager.persist(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> findAll() {
        TypedQuery<Fruit> foundAll = entityManager.createQuery("SELECT f FROM Fruit f", Fruit.class);

        return foundAll.getResultList();
    }

    @Override
    public Fruit findById(long id) {
        Fruit fruit = entityManager.find(Fruit.class, id);
        if(fruit == null){
            throw new PlantException("Fruit with given id is not exist " + id, HttpStatus.NOT_FOUND);

        }
        return fruit;
    }
    @Transactional
    @Override
    public Fruit update(Fruit fruit) {
        return entityManager.merge(fruit);
    }

    @Transactional
    @Override
    public Fruit remove(long id) {
        Fruit foundFruit = findById(id);
        entityManager.remove(foundFruit);
        return foundFruit;
    }

    @Override
    public List<Fruit> findByPrice(double price) {
        TypedQuery<Fruit> foundListQuery =
                entityManager.createQuery("SELECT f FROM Fruit f WHERE f.price > :price ORDER BY f.price DESC", Fruit.class);
        foundListQuery.setParameter("price",price);
        return foundListQuery.getResultList();
    }

    @Override
    public List<Fruit> findByFruitType(FruitType fruitType) {
        TypedQuery<Fruit> query =
                entityManager.createQuery("SELECT f FROM Fruit f WHERE f.fruitType = :fruitType ORDER BY f.name DESC", Fruit.class);
        query.setParameter("fruitType", fruitType);
        return query.getResultList();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        TypedQuery<Fruit> query =
                entityManager.createQuery("SELECT f FROM Fruit f ORDER BY f.price DESC", Fruit.class);
        return query.getResultList();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        TypedQuery<Fruit> query =
                entityManager.createQuery("SELECT f FROM Fruit f ORDER BY f.price ASC", Fruit.class);
        return query.getResultList();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        TypedQuery<Fruit> query =
                entityManager.createQuery("SELECT f FROM Fruit f WHERE LOWER(f.name) LIKE LOWER(:name)", Fruit.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
