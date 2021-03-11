package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.data.Delivery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class DeliveryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery){
        entityManager.persist(delivery);
    }

    public Delivery find(Long id){
        Delivery delivery = entityManager.find(Delivery.class, id);
        return delivery;
    }


    public Delivery merge(Delivery delivery){
        Delivery managedDelivery = entityManager.merge(delivery);
        return managedDelivery;
    }

    public void delete(Long id){
        Delivery deliveryToDelete = entityManager.find(Delivery.class, id);
        entityManager.remove(deliveryToDelete);
    }

}
