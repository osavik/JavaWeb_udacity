package com.example.demo.dao;

import com.example.demo.model.FleetManager;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class FleetManagerDataAccessService implements FleetManagerDao {
    @Override
    public int insertFleetManager(UUID id, FleetManager fleetManager) {
        return 0;
    }

    @Override
    public List<FleetManager> selectAllFleetManagers() {
        return List.of(new FleetManager(UUID.randomUUID(), "From Postgres DB"));
    }

    @Override
    public Optional<FleetManager> selectFleetManagerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deleteFleetManagerById(UUID id) {
        return 0;
    }

    @Override
    public int updateFleetManagerById(UUID id, FleetManager fleetManager) {
        return 0;
    }
}
