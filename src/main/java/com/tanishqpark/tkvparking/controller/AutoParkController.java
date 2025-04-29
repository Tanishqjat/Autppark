package com.tanishqpark.tkvparking.controller;

import com.tanishqpark.tkvparking.model.ParkingSlotBooking;
import com.tanishqpark.tkvparking.service.EmailService;
import com.tanishqpark.tkvparking.service.ParkingSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class AutoParkController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    // Existing payment calculation endpoint
    @PostMapping("/calculate")
    public Map<String, Double> calculatePayment(@RequestBody Map<String, Integer> request) {
        int parkingTime = request.get("parkingTime");
        double ratePerHour = 50.0;
        double totalAmount = parkingTime * ratePerHour;
        double advanceAmount = totalAmount * 0.3;

        Map<String, Double> response = new HashMap<>();
        response.put("totalAmount", totalAmount);
        response.put("advanceAmount", advanceAmount);
        return response;
    }

    // Updated slot booking endpoint
    @Autowired
private EmailService emailService;
    @PostMapping("/parking-slots")  // Use /parking-slots for booking
    // public String bookParkingSlot(@RequestBody ParkingSlotBooking booking) {
    //     boolean isBooked = parkingSlotService.bookParkingSlot(booking);

    //     if (isBooked) {
    //         return "Parking slot booked successfully!";
    //     } else {
    //         return "Failed to book the parking slot. Please try again.";
    //     }
    // }
    public String bookParkingSlot(@RequestBody ParkingSlotBooking booking) {
        boolean isBooked = parkingSlotService.bookParkingSlot(booking);
    
        if (isBooked) {
            emailService.sendNoReplyEmail(
                booking.getEmail(), // Booking object mein email field hona chahiye
                "Parking Slot Confirmation",
                "Dear " + booking.getName() + ",\n\nYour parking slot is confirmed. Thank you!"
            );
            return "Parking slot booked and confirmation email sent!";
        } else {
            return "Failed to book the parking slot. Please try again.";
        }
    }
    

    // Endpoint to fetch all booked slots (optional)
    @GetMapping("/bookedSlots")
    public List<ParkingSlotBooking> getAllBookedSlots() {
        return parkingSlotService.getAllBookings();
    }
}
