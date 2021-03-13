package com.udacity.jdnd.course3.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.jdnd.course3.data.Delivery;
import com.udacity.jdnd.course3.data.Plant;
import com.udacity.jdnd.course3.data.dto.PlantDTO;
import com.udacity.jdnd.course3.data.dto.RecipientAndPriceDTO;
import com.udacity.jdnd.course3.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name){
        Plant plant = plantService.getPlantByName(name);
        return convertPlantToPlantDTO(plant);
    }

    @JsonView(View.Public.class)
    public Plant getFilteredPlant(String name){
        return plantService.getPlantByName(name);
    }

    private static PlantDTO convertPlantToPlantDTO(Plant plant){
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }

    @GetMapping("/isdelivered/{id}")
    public Boolean isPlantDelivered(@PathVariable String id){
        Boolean isDelivered = plantService.checkIfDelivered(Long.valueOf(id));
        return isDelivered;
    }

    @GetMapping("/cheaper/{price}")
    public ResponseEntity<List<PlantDTO>> getPlantsCheaperThanPrice(@PathVariable Double price){
        BigDecimal priceBD = BigDecimal.valueOf(price);

        List <Plant> plants = plantService.getPlantsBelowPrice(priceBD);
        List<PlantDTO> plantDTOS = new ArrayList<>();
        for (Plant plant : plants){
            plantDTOS.add(convertPlantToPlantDTO(plant));
        }

        return new ResponseEntity<List<PlantDTO>>(plantDTOS, HttpStatus.OK);
    }

    // to test solution from udacity
    @GetMapping("/delivered/{id}")
    public Boolean delivered(@PathVariable Long id) {
        return plantService.delivered(id);
    }



}
