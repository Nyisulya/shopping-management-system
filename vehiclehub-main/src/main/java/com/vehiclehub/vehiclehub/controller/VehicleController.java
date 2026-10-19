package com.vehiclehub.vehiclehub.controller;

import com.vehiclehub.vehiclehub.entity.Vehicle;
import com.vehiclehub.vehiclehub.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // 1. CREATE - POST
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.createVehicle(vehicle);
    }

    // 2. GET ALL - GET
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // 3. GET ONE - GET
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // FILTER - GET
    @GetMapping("/filter")
    public List<Vehicle> filterVehicles(
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String vehicleType,
            @RequestParam(required = false) String fuelType,
            @RequestParam(required = false) String transmission,
            @RequestParam(required = false) String availabilityStatus) {

        return vehicleService.filterVehicles(
                make,
                vehicleType,
                fuelType,
                transmission,
                availabilityStatus
        );
    }

    // 4. UPDATE - PUT
    @PutMapping("/{id}")
    public Vehicle updateVehicle(
            @PathVariable Long id,
            @RequestBody Vehicle vehicleDetails) {

        return vehicleService.updateVehicle(id, vehicleDetails);
    }

    // 5. DELETE - DELETE
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {

        boolean deleted = vehicleService.deleteVehicle(id);

        if (deleted) {
            return "Vehicle deleted successfully";
        }

        return "Vehicle not found";
    }
}
