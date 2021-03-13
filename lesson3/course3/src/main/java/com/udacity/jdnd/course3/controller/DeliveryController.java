package com.udacity.jdnd.course3.controller;

import com.udacity.jdnd.course3.data.Delivery;
import com.udacity.jdnd.course3.data.dto.RecipientAndPriceDTO;
import com.udacity.jdnd.course3.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Delivery>> getAllDeliveriesByName(@PathVariable String name){

        List<Delivery> deliveries = deliveryService.getDeliveriesByName(name);
        return new ResponseEntity<List<Delivery>>(deliveries, HttpStatus.OK);
    }

    @GetMapping("/nameandprice/{deliveryId}")
    public ResponseEntity<RecipientAndPriceDTO> getRecipientNameAndPriceSum(
            @PathVariable String deliveryId){
        RecipientAndPriceDTO recipientAndPriceDTO =
                deliveryService.findRecipientNameAndPriceSum(Long.valueOf(deliveryId));

        return new ResponseEntity<RecipientAndPriceDTO>(recipientAndPriceDTO, HttpStatus.OK);
    }

    @PutMapping("/status/{id}/{newstatus}")
    public ResponseEntity<Delivery> changeDeliveryStatus(@PathVariable Long id, @PathVariable Boolean newstatus){
        Delivery delivery = deliveryService.changeDeliveryStatus(id, newstatus);

        return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);
    }



}
