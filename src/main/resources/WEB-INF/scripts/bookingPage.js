var prefix = 'http://localhost:8080/';

var url = new URL(window.location.href);
var params = new URLSearchParams(url.search);

var field_id = params.get('id');
console.log(field_id);

window.onload = function() {
    console.log('onload works');
    getField();
};

let cost = 0;

var bookField = function () {


    var fieldCost = cost;
    var bookDuration = $("#input-duration").val();
    var bookDate = $("#input-date").val();


    // МЕГА КОСТЫЛЬ!!!
    //DATE PARSE
    var date_year = bookDate.substr(0,4);
    var date_month = bookDate.substr(5,2);
    var date_day = bookDate.substr(8,2);
    var date_hours = bookDate.substr(11,2);
    var date_minutes = bookDate.substr(14,2);
    //----------

    console.log(bookDate);
    // console.log(date_year);
    // console.log(date_month);
    // console.log(date_day);
    // console.log(date_hours);
    // console.log(date_minutes);


    //КОСТЫЛЬ
    var customer_id = 7; //company's id

    $.ajax({
        type: 'POST',
        url: prefix + 'create?date='
            + date_day + '-'
            + date_month + '-'
            + date_year + '-'
            + date_hours + ':'
            + date_minutes + '&'
            + 'status=ACCEPTED&'
            + 'id=' + customer_id,
        dataType: 'json',
        async: true,
        data: JSON.stringify(
            {
                customer:
                    {id:customer_id},
                footballField:
                    {id:field_id},
                bookHours:bookDuration
            },
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
        }
    })
};

const getField = async () => {
    const response = await fetch(prefix + 'football/' + field_id);
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);
    cost = myJson.cost;
    // return (input-duration * field.cost = summary_cost) + ' вот столько плати нахуй!э'

    var output = 'Field address: ' + myJson.address +
        '<br>Cost per hour: ' + myJson.cost + ' soms';

    // '<a href="http://localhost:8080/bookingPage.html?id=" + field.id>' + field.address + '</a>';
    $('#content-field').html(output);
    // $('#content-field').html( JSON.stringify( myJson ) );
};