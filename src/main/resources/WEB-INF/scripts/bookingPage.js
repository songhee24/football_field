let prefix = 'http://localhost:8080/';

let url = new URL(window.location.href);
let params = new URLSearchParams(url.search);

let field_id = params.get('id');
console.log(field_id);

window.onload = function() {
    console.log('onload works');
    getField();
};

let cost = 0;

let bookField = function () {


    let fieldCost = cost;
    let bookDuration = $("#input-duration").val();
    let bookDate = $("#input-date").val();




    // МЕГА КОСТЫЛЬ!!!
    //DATE PARSE
    let date_year = bookDate.substr(0,4);
    let date_month = bookDate.substr(5,2);
    let date_day = bookDate.substr(8,2);
    let date_hours = bookDate.substr(11,2);
    let date_minutes = bookDate.substr(14,2);
    //----------

    console.log(bookDate);
    // console.log(date_year);
    // console.log(date_month);
    // console.log(date_day);
    // console.log(date_hours);
    // console.log(date_minutes);


    //КОСТЫЛЬ
    let customer_id = 5; //customer_id

    $.ajax({
        type: 'POST',
        url: prefix + 'Booking/create?date='
            + date_day + '-'
            + date_month + '-'
            + date_year + '-'
            + date_hours + ':'
            + date_minutes + '&'
            + 'status=ACCEPTED&'
            + 'accountFromId=' + customer_id,
        dataType: 'json',
        async: true,
        data: JSON.stringify(
            {
                customer: {
                    id:customer_id
                },
                footballField: {
                    id:field_id
                },
                bookHours:bookDuration
            }
        ),
        headers: {
            //tells my application that it sends it on JSON
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (result) {
            console.log('LOG_result: ' + result)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            //just to know wtf is happening
            console.log("bookDuration: " + bookDuration);
            console.log("bookDate: " + bookDate);
            console.log("customer: " + customer_id);
            console.log("booking date: " +date_day+'-'+date_month+'-'+date_year+'-'+date_hours+':'+date_minutes);
            console.log("json: " +JSON.stringify(
                {
                    customer: {
                        id:customer_id
                    },
                    footballField: {
                        id:field_id
                    },
                    bookHours:bookDuration
                }
            ))
        }
    })
};

const getField = async () => {
    const response = await fetch(prefix + 'football/' + field_id);
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);
    cost = myJson.cost;
    // return (input-duration * field.cost = summary_cost) + ' вот столько плати нахуй!э'

    let output = 'Field address: ' + myJson.address +
        '<br>Cost per hour: ' + myJson.cost + ' soms';

    // '<a href="http://localhost:8080/bookingPage.html?id=" + field.id>' + field.address + '</a>';
    $('#content-field').html(output);
    // $('#content-field').html( JSON.stringify( myJson ) );
};