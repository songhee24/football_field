package com.football_field.football_field.Controllers;


import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Servicies.BookedFieldService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

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
    public BookedField create(@RequestParam String date, @RequestBody BookedField book
            , @RequestParam Status status, @RequestParam Long id) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy-hh:mm");
        try {
            Date newDate = simpleDateFormat.parse(date);
            book.setBookTime(newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        dd-M-yyyy hh:mm
        return bookedFieldService.createBooking(book, status, id);
    }

    @GetMapping("/testo")
    public void timeTest(@RequestParam Long id) {
        String stringDate = "30-4-2020-19:25";
        int hours = 2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy-hh:mm");
        try {
            Date startDate = simpleDateFormat.parse(stringDate);
            Date endDate = getDateByHourAdding(startDate, hours);
            System.err.println("StartDate: " + startDate);
            System.err.println("EndDate: " + endDate);
            System.err.println("is Old smaller: " + startDate.compareTo(endDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        LinkedHashMap<Date, Integer> map = new LinkedHashMap<>();
        List<BookedField> fields = bookedFieldService.getAllByFootballField_Id(id);
        for (BookedField field : fields) {
            map.put(field.getBookTime(), field.getBookHours());
            System.out.println("field.getBookTime() = " + field.getBookTime());
            System.out.println("field.getBookHours() = " + field.getBookHours());
        }
    }

    public Date getDateFromString(String stringDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy-hh:mm");
        Date date = null;
        try {
             date = simpleDateFormat.parse(stringDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    @GetMapping("/check")
    public void test(
            @RequestParam String date,
            @RequestParam int hours,
            @RequestParam Long fieldId
    ) {
        Date startDate = getDateFromString(date);

        System.out.println("isDateFree = " + isCurrentDateIsFree(
                fieldId,
                startDate,
                hours
        ));

    }

    public boolean isCurrentDateIsFree(Long fieldId, Date startDate, int hours) {
        Date endDate = getDateByHourAdding(startDate, hours);

        List<BookedField> fields = bookedFieldService.getAllByFootballField_Id(fieldId);
        for (BookedField field : fields) {
            if (!isDatesNotEqual(
                    startDate,
                    endDate,
                    field.getBookTime(),
                    getDateByHourAdding(field.getBookTime(), field.getBookHours())
            )) {
                return false;
            }
        }
        return true;
    }

    public boolean isDatesNotEqual(
            //input dates
            Date startDate1,
            Date endDate1,
            //dates of existing bookings
            Date startDate2,
            Date endDate2
    ) {
        if (
                // <<
                (startDate1.compareTo(startDate2) < 0) && (endDate1.compareTo(startDate2) <= 0)
                // >>
                || (startDate1.compareTo(endDate2) >= 0) && (endDate1.compareTo(endDate2) > 0)

                //possible easier option
                /*
                * endDate1.ct(startDate2) <= 0 or startDate1.ct(endDate2) >= 0
                *
                * */
        ) {
            return true;
        }
        return false;
    }

    public Date getDateByHourAdding(Date date, int hours) {
        Date newDate = (Date)date.clone();
        newDate.setHours(newDate.getHours() + hours);
        return newDate;
    }

//    date =>   start
//    newDate => end
//
//    want_date
//
//    want_time << start & << end
//    want_time >> start & >> end

    @PostMapping("/save")
    public BookedField save(@RequestBody BookedField customer) {
        return bookedFieldService.save(customer);
    }

    @GetMapping("/getAll")
    public List<BookedField> getAll() {
        return bookedFieldService.getAll();
    }
}
