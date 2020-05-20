package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.BookedField;
import com.football_field.football_field.Entities.Customer;
import com.football_field.football_field.Entities.FootballField;
import com.football_field.football_field.Entities.Payment;
import com.football_field.football_field.Repositories.BookedFieldRepository;
import com.football_field.football_field.Repositories.CustomerRepository;
import com.football_field.football_field.Servicies.BookedFieldService;
import com.football_field.football_field.Servicies.CustomerService;
import com.football_field.football_field.Servicies.FootballFieldService;
import com.football_field.football_field.Servicies.PaymentService;
import com.football_field.football_field.Statuses.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookedFieldServiceImpl implements BookedFieldService {
    @Autowired
    private BookedFieldRepository bookedFieldRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FootballFieldService footballFieldService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public BookedField getById(Long id) {
        Optional<BookedField> booking = bookedFieldRepository.findById(id);
        return booking.get();
    }

    @Override
    public List<BookedField> getAll() {
        return bookedFieldRepository.findAll();
    }

    @Override
    public BookedField createBooking(BookedField bookedField, Status status, Long id) {
        //TESTME где сейчас проходит валидация по дате ? (на уровне JS проходит)
        //TESTME сейчас валидации по дате при создании брони нету!
        //TESTME ошибка возникет в findPayemnt.. потому, что неправильный findPayment..

        if (isCurrentDateIsFree(bookedField.getFootballField().getId(), bookedField.getBookTime(), bookedField.getBookHours())) {

            System.err.println("LOG_BookFieldServiceImpl: date validation passed");
//        Payment payment = paymentService.findPaymentByStatusAndAccountFrom_Id(status, id);
//        System.err.println("Creating Booking->payment: " + payment.toString());
//        if (payment.getStatus() == Status.ACCEPTED) {
//            Customer customer = customerService.getById(payment.getAccountFrom().getId());
            Customer customer = customerService.getById(id);
            FootballField field = footballFieldService.getById(bookedField.getFootballField().getId());
            bookedField.setCustomer(customer);
            bookedField.setFootballField(field);
            return save(bookedField);
//        }
        }
        return null;
    }

    @Override
    public List<BookedField> getAllByFootballField_Id(Long id) {
        return bookedFieldRepository.getAllByFootballField_Id(id);
    }

    @Override
    public BookedField save(BookedField item) {
        return bookedFieldRepository.save(item);
    }

    @Override
    public boolean isCurrentDateIsFree(Long fieldId, Date startDate, int hours) {
        Date endDate = getDateByHourAdding(startDate, hours);

        List<BookedField> fields = bookedFieldRepository.getAllByFootballField_Id(fieldId);
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
        Date newDate = (Date) date.clone();
        newDate.setHours(newDate.getHours() + hours);
        return newDate;
    }
}
