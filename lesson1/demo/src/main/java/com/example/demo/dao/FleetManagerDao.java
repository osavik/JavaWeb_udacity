package com.example.demo.dao;

import com.example.demo.model.FleetManager;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FleetManagerDao {

    int insertFleetManager(UUID id, FleetManager fleetManager);

    default int insertFleetManager(FleetManager fleetManager){
        UUID id = UUID.randomUUID();
        return insertFleetManager(id, fleetManager);
    }

    List<FleetManager> selectAllFleetManagers();

    Optional <FleetManager> selectFleetManagerById(UUID id);

    int deleteFleetManagerById( UUID id);

    int updateFleetManagerById(UUID id, FleetManager fleetManager);
}
