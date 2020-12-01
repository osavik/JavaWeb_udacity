package com.example.demo.dao;

import com.example.demo.model.FleetManager;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository ("fakeDao")
public class FakeFleetManagerDataAccessService implements FleetManagerDao {

    private static List<FleetManager> DB = new ArrayList<>();

    @Override
    public int insertFleetManager(UUID id, FleetManager fleetManager) {
        DB.add(new FleetManager(id, fleetManager.getName()));
        return 1;
    }

    @Override
    public List<FleetManager> selectAllFleetManagers() {
        return DB;
    }

    @Override
    public Optional<FleetManager> selectFleetManagerById(UUID id) {
        return DB.stream()
                .filter(fleetManager -> fleetManager.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteFleetManagerById(UUID id) {
        Optional <FleetManager> fleetManager = selectFleetManagerById(id);
        if (fleetManager.isEmpty()){
            return 0;
        }
        DB.remove(fleetManager.get());
        return 1;
    }

    @Override
    public int updateFleetManagerById(UUID id, FleetManager fleetManager) {
        return selectFleetManagerById(id)
                .map(manager -> {
                    int indexOfManagerToUpdate = DB.indexOf(manager);
                    if (indexOfManagerToUpdate >= 0){
                        DB.set(indexOfManagerToUpdate, new FleetManager(id, fleetManager.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
