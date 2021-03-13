package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.data.Delivery;
import com.udacity.jdnd.course3.data.dto.RecipientAndPriceDTO;
import com.udacity.jdnd.course3.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public List<Delivery> getDeliveriesByName(String name){
        return deliveryRepository.findDeliveriesByRecipientName(name);
    }

    public RecipientAndPriceDTO findRecipientNameAndPriceSum(long deliveryId){
        return deliveryRepository.findByRecipientNameAndDeliveryPriceSum(deliveryId);
    }

    public Delivery changeDeliveryStatus(Long id, Boolean status){
        return deliveryRepository.changeDeliveryStatus(id, status);
    }

}
