package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.Booking;

public interface BookingService extends BaseService<Booking> {
    Booking createBooking(Booking booking);
}
