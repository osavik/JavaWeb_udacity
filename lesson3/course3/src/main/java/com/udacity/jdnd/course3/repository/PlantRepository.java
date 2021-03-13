package com.udacity.jdnd.course3.repository;

import com.udacity.jdnd.course3.data.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository <Plant, Long> {

    @Query("select p.delivery.isCompleted from Plant p where :id = p.id")
    Boolean isPlantDelivered(Long id);

    List<Plant> findByPriceLessThan(BigDecimal price);


    // solutions from udacity
    //check if a plant by this id exists where delivery has been completed
    Boolean existsPlantByIdAndDeliveryIsCompleted(Long id, Boolean delivered);

    //you can return a primitive directly
    @Query("select p.delivery.isCompleted from Plant p where p.id = :plantId")
    Boolean deliveryIsCompleted(Long plantId);

    //to return a wrapper class, you may need to construct it as a projection
    @Query("select new java.lang.Boolean(p.delivery.isCompleted) from Plant p where p.id = :plantId")
    Boolean deliveryCompletedBoolean(Long plantId);
}
