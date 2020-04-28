package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.Booking;
import com.football_field.football_field.Servicies.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/save")
    public Booking save(@RequestBody Booking customer){
        return bookingService.save(customer);
    }

    @GetMapping("/getAll")
    public List<Booking> getAll(){
        return bookingService.getAll();
    }
}
