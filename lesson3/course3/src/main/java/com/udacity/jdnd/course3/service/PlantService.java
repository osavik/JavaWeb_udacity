package com.udacity.jdnd.course3.service;

import com.udacity.jdnd.course3.data.Plant;
import com.udacity.jdnd.course3.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    PlantRepository plantRepository;

    public Plant getPlantByName(String name){
        return new Plant();
    }

    public Long save(Plant plant){
        return plantRepository.save(plant).getId();
    }

    public Boolean checkIfDelivered(Long id){
        return plantRepository.isPlantDelivered(id);
    }

    public List<Plant> getPlantsBelowPrice(BigDecimal price){
        return plantRepository.findByPriceLessThan(price);
    }

    // to test solution from udacity
    public Boolean delivered(Long id){
        // return plantRepository.deliveryCompleted(id);
        return plantRepository.deliveryIsCompleted(id);
    }


}
