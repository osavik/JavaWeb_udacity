package com.example.demo.service;

import com.example.demo.dao.FleetManagerDao;
import com.example.demo.model.FleetManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FleetManagerService {

    private final FleetManagerDao fleetManagerDao;

    @Autowired
    public FleetManagerService(@Qualifier("postgres") FleetManagerDao fleetManagerDao) {
        this.fleetManagerDao = fleetManagerDao;
    }

    public int addFleetManager(FleetManager fleetManager){
        return fleetManagerDao.insertFleetManager(fleetManager);
    }

    public List<FleetManager> getAllFleetManagers(){
        return fleetManagerDao.selectAllFleetManagers();
    }

    public Optional<FleetManager> getFleetManagerById(UUID id){
        return fleetManagerDao.selectFleetManagerById(id);
    }

    public int deleteFleetManagerById(UUID id){
        return fleetManagerDao.deleteFleetManagerById(id);
    }

    public int updateFleetManagerById(UUID id, FleetManager fleetManager){
        return fleetManagerDao.updateFleetManagerById(id, fleetManager);
    }
}
