package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Servicies.BookedFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Booking")
public class BookingController {
    @Autowired
    private BookedFieldService bookedFieldService;

    //PostMapping
    //params, model
    // method {
    //      1.
    // }

    @PostMapping("/create")
    public BookedField create(@RequestParam String date, @RequestBody BookedField book) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy-hh:mm");
        try {
            Date newDate = simpleDateFormat.parse(date);
            book.setBookTime(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        dd-M-yyyy hh:mm
        return bookedFieldService.createBooking(book);
    }

    @PostMapping("/save")
    public BookedField save(@RequestBody BookedField customer){
        return bookedFieldService.save(customer);
    }

    @GetMapping("/getAll")
    public List<BookedField> getAll(){
        return bookedFieldService.getAll();
    }
}
