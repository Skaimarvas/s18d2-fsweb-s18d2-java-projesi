package com.example.s18d2.dao;

import com.example.s18d2.entity.Fruit;
import com.example.s18d2.entity.FruitType;
import com.example.s18d2.entity.Vegetable;
import com.example.s18d2.exceptions.PlantException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VegetableDaoImpl implements VegetableDao {
    private final EntityManager entityManager;

    @Autowired
    public VegetableDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public Vegetable save(Vegetable vegetable) {
        entityManager.persist(vegetable);
        return vegetable;
    }

    @Override
    public List<Vegetable> findAll() {
        TypedQuery<Vegetable> foundAll = entityManager.createQuery("SELECT v FROM Vegetable v", Vegetable.class);
        return foundAll.getResultList();
    }

    @Override
    public Vegetable findById(long id) {
        Vegetable vegetable = entityManager.find(Vegetable.class, id);
        if(vegetable == null){
            throw new PlantException("Vegetable with given id is not exist " + id, HttpStatus.NOT_FOUND);

        }
        return vegetable;
    }
    @Transactional
    @Override
    public Vegetable update(Vegetable vegetable) {
        return entityManager.merge(vegetable);
    }

    @Transactional
    @Override
    public Vegetable remove(long id) {
        Vegetable foundVegetable = findById(id);
        entityManager.remove(foundVegetable);
        return foundVegetable;
    }

    @Override
    public List<Vegetable> findByPrice(double price) {
        TypedQuery<Vegetable> foundListQuery =
                entityManager.createQuery("SELECT v FROM Vegetable v WHERE v.price > :price ORDER BY v.price DESC", Vegetable.class);
        foundListQuery.setParameter("price",price);
        return foundListQuery.getResultList();
    }

    @Override
    public List<Vegetable> findByGrownOnTree(boolean grownOnTree) {
        TypedQuery<Vegetable> query =
                entityManager.createQuery("SELECT v FROM Vegetable v WHERE v.is_grown_on_tree = :grownOnTree ORDER BY v.name DESC", Vegetable.class);
        query.setParameter("grownOnTree", grownOnTree);
        return query.getResultList();
    }
    @Override
    public List<Vegetable> getByPriceDesc() {
        TypedQuery<Vegetable> query =
                entityManager.createQuery("SELECT v FROM Vegetable v ORDER BY v.price DESC", Vegetable.class);
        return query.getResultList();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        TypedQuery<Vegetable> query =
                entityManager.createQuery("SELECT v FROM Vegetable v ORDER BY v.price ASC", Vegetable.class);
        return query.getResultList();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        TypedQuery<Vegetable> query =
                entityManager.createQuery("SELECT v FROM Vegetable v WHERE LOWER(v.name) LIKE LOWER(:name)", Vegetable.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
