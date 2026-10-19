package com.vehiclehub.vehiclehub.repository;

import com.vehiclehub.vehiclehub.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    
    List<Vehicle> findByMakeIgnoreCase(String make);

    List<Vehicle> findByVehicleTypeIgnoreCase(String vehicleType);

    List<Vehicle> findByFuelTypeIgnoreCase(String fuelType);

    List<Vehicle> findByTransmissionIgnoreCase(String transmission);

    List<Vehicle> findByAvailabilityStatusIgnoreCase(String availabilityStatus);
}
