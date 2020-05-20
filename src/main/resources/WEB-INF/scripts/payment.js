let prefix = 'http://localhost:8080/';

let url = new URL(window.location.href);
let params = new URLSearchParams(url.search);

let field_id = params.get('field_id');
let field_cost = params.get('field_cost');
let field_address = params.get('field_address');
let book_date = params.get('date');
let book_duration = params.get('book_hours');
let payment_status = 'ACCEPTED';

let customer_id = 11;
let company_id = 13;


window.onload = function() {
    console.log('onload works');

    $('#field-address').html('Field address: '+ field_address);
    $('#reserve-time').html('at ' + book_date + ' for ' + book_duration + ' hours');
    $('#total-cost').html('Total cost: ' + field_cost * book_duration + ' soms');

};

let make_pay = function () {
    console.log('make_pay started');

    $.ajax({
        type: 'POST',
        url: prefix + 'payment?fieldId=' + field_id + '&book_hours=' + book_duration,
        dataType: 'json',
        async: true,
        data: JSON.stringify(
            {
                accountFrom: {id: customer_id}, //richest_customer
                accountTo: {id: company_id}, //company_id
                status: payment_status
            }),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (result) {
            console.log('LOG_make_pay->result: ' + result.toString());
            alert('payment is successful!')
            //call create booking
            createBooking();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};

let createBooking = function () {
    console.log('createBooking started');

    $.ajax({
        type:'POST',
        url: prefix + 'booking/create?date=' + book_date +'&'
                    + 'status=' + payment_status + '&'
                    + 'accountFromId=' + customer_id,
        dataType: 'json',
        async: true,
        data: JSON.stringify({
            customer: {id: customer_id},
            footballField: {id:field_id},
            bookHours: book_duration
        }),
        headers: {
            //tells my application that it sends it on JSON
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (result) {
            console.log('LOG_createBooking->result: ' + result.toString());
            alert('field booked successfully!')
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });

};