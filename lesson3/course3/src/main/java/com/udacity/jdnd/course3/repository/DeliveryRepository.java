package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.data.Delivery;
import com.udacity.jdnd.course3.data.Plant;
import com.udacity.jdnd.course3.data.dto.RecipientAndPriceDTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


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

    public Delivery changeDeliveryStatus(Long id, Boolean status){
        Delivery delivery = entityManager.find(Delivery.class, id);
        delivery.setCompleted(status);
        return delivery;
    }

    public List<Delivery> findDeliveriesByRecipientName(String recipientName){
        TypedQuery<Delivery> query = entityManager.createNamedQuery(
                "Delivery.findByRecipientName", Delivery.class);

        query.setParameter("recipientName", recipientName);

        return query.getResultList();
    }


    public RecipientAndPriceDTO findByRecipientNameAndDeliveryPriceSum(long deliveryId){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPriceDTO> query = cb.createQuery(RecipientAndPriceDTO.class);

        Root<Plant> root = query.from(Plant.class);
        query.select(
                cb.construct(
                        RecipientAndPriceDTO.class,
                        root.get("delivery").get("recipientName"),
                        cb.sum(root.get("price"))))
                .where(cb.equal(root.get("delivery").get("id"), deliveryId));

        return entityManager.createQuery(query).getSingleResult();
    }

}
