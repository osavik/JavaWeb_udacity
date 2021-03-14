package com.udacity.jdnd.course3;

import com.udacity.jdnd.course3.data.Delivery;
import com.udacity.jdnd.course3.data.Plant;
import com.udacity.jdnd.course3.repository.DeliveryRepository;
import com.udacity.jdnd.course3.repository.PlantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.http.HttpStatus;

import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
public class PlantRepositoryUnitTests {

    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    PlantRepository plantRepository;

    @Test
    public void testPriceLessThan(){

        Plant plant1 = new Plant(null, "Plant1", new BigDecimal(3.5), null);
        Plant plant2 = new Plant(null, "Plant2", new BigDecimal(7.5), null);

        testEntityManager.persist(plant1);
        testEntityManager.persist(plant2);

        List<Plant> plantList = plantRepository.findByPriceLessThan(new BigDecimal(4.0));

        assertThat(plantList.size(), equalTo(1));
        Assertions.assertEquals(1, plantList.size(), "Size");
        assertThat(plantList.get(0).getName(), equalTo("Plant1"));
        assertThat(plantList.get(0).getPrice(), equalTo(new BigDecimal(3.5)));
    }


    @Test
    public void testDeliveryCompleted(){
        Plant plant1 = new Plant(null, "Plant1", new BigDecimal(3.5), null);
        Plant plant2 = new Plant(null, "Plant2", new BigDecimal(7.5), null);

        List<Plant> plants = new ArrayList<>();
        plants.add(plant1);
        plants.add(plant2);

        Delivery delivery = new Delivery(null, "Viktor",
                "Viktor's address", LocalDateTime.now(),
                false,plants);

        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        testEntityManager.persist(delivery);

        assertThat(plantRepository.isPlantDelivered(delivery.getPlants().get(0).getId()),equalTo(false));

        delivery.setCompleted(true);
        assertThat(plantRepository.isPlantDelivered(delivery.getPlants().get(0).getId()),equalTo(true));


    }




}
