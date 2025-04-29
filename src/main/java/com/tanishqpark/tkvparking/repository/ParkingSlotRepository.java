package com.tanishqpark.tkvparking.repository;

import com.tanishqpark.tkvparking.model.ParkingSlotBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlotBooking, Long> {
}
