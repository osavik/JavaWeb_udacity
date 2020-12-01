package com.example.demo.api;

import com.example.demo.model.FleetManager;
import com.example.demo.service.FleetManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/fleetmanager")
@RestController
public class FleetManagerController {

    private final FleetManagerService fleetManagerService;

    @Autowired
    public FleetManagerController(FleetManagerService fleetManagerService) {
        this.fleetManagerService = fleetManagerService;
    }

    @PostMapping
    public void addFleetManager(@Valid @NonNull @RequestBody FleetManager fleetManager){
        fleetManagerService.addFleetManager(fleetManager);
    }

    @GetMapping
    public List<FleetManager> getAllFleetManagers(){
        return fleetManagerService.getAllFleetManagers();
    }

    @GetMapping(path = "{id}")
    public FleetManager getFleetManagerById(@PathVariable("id") UUID id){
        return fleetManagerService.getFleetManagerById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteFleetManagerById(@PathVariable("id") UUID id){
        fleetManagerService.deleteFleetManagerById(id);
    }

    @PutMapping(path = "{id}")
    public void updateFleetManagerById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody FleetManager fleetManager){
        fleetManagerService.updateFleetManagerById(id, fleetManager);
    }
}
