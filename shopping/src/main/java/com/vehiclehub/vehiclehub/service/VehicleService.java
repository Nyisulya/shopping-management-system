package com.vehiclehub.vehiclehub.service;

import com.vehiclehub.vehiclehub.entity.Vehicle;
import com.vehiclehub.vehiclehub.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    // Create a new vehicle
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Get all vehicles
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Get vehicle by ID
    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    // Update vehicle
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return null;
        }

        vehicle.setMake(vehicleDetails.getMake());
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setVehicleType(vehicleDetails.getVehicleType());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setMileage(vehicleDetails.getMileage());
        vehicle.setEngineCapacity(vehicleDetails.getEngineCapacity());
        vehicle.setFuelType(vehicleDetails.getFuelType());
        vehicle.setTransmission(vehicleDetails.getTransmission());
        vehicle.setColor(vehicleDetails.getColor());
        vehicle.setCondition(vehicleDetails.getCondition());
        vehicle.setSeats(vehicleDetails.getSeats());
        vehicle.setDescription(vehicleDetails.getDescription());
        vehicle.setLocation(vehicleDetails.getLocation());
        vehicle.setAvailabilityStatus(vehicleDetails.getAvailabilityStatus());

        return vehicleRepository.save(vehicle);
    }

    // Delete vehicle
    public boolean deleteVehicle(Long id) {

        Vehicle vehicle = vehicleRepository.findById(id).orElse(null);

        if (vehicle == null) {
            return false;
        }

        vehicleRepository.delete(vehicle);
        return true;
    }

    // Filter vehicles
    public List<Vehicle> filterVehicles(
            String make,
            String vehicleType,
            String fuelType,
            String transmission,
            String availabilityStatus) {

        if (make != null) {
            return vehicleRepository.findByMakeIgnoreCase(make);
        }

        if (vehicleType != null) {
            return vehicleRepository.findByVehicleTypeIgnoreCase(vehicleType);
        }

        if (fuelType != null) {
            return vehicleRepository.findByFuelTypeIgnoreCase(fuelType);
        }

        if (transmission != null) {
            return vehicleRepository.findByTransmissionIgnoreCase(transmission);
        }

        if (availabilityStatus != null) {
            return vehicleRepository.findByAvailabilityStatusIgnoreCase(availabilityStatus);
        }

        return vehicleRepository.findAll();
    }
}
