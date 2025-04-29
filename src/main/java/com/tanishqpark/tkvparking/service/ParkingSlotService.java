package com.tanishqpark.tkvparking.service;

import com.tanishqpark.tkvparking.model.ParkingSlotBooking;
import com.tanishqpark.tkvparking.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingSlotService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    /**
     * 
     * @param booking 
     * @return 
     */
    public boolean bookParkingSlot(ParkingSlotBooking booking) {
        System.out.println("Booking details : " + booking);
        try {
            
            if (booking == null) {
                System.err.println("Booking object is null");
                return false;
            }
            
            parkingSlotRepository.save(booking);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving booking: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }

    /**
     *
     * @return 
     */
    public List<ParkingSlotBooking> getAllBookings() {
        return parkingSlotRepository.findAll();
    }

    /**
     * 
     * @param id 
     * @return 
     */
    public ParkingSlotBooking getBookingById(Long id) {
        return parkingSlotRepository.findById(id).orElse(null);
    }

    /**
     * 
     * @param id 
     * @return 
     */
    public boolean deleteBooking(Long id) {
        try {
            if (parkingSlotRepository.existsById(id)) {
                parkingSlotRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error while deleting parking slot: " + e.getMessage());
            return false;
        }
    }
}