package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Statuses.Status;

import java.util.Date;

public interface BookedFieldService extends BaseService<BookedField> {
    BookedField createBooking(BookedField bookedField, Status status,Long id);
}
