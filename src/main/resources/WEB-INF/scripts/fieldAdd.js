let prefix = 'http://localhost:8080/';

let createField = function () {
    let fieldCost = $("#field-cost-id").val();
    let fieldAddress = $("#field-address-id").val();
    let ownerId = $("#field-ownerId-id").val();

    $.ajax({
        type: 'POST',
        url: prefix + 'football/create',
        dataType: 'json',
        async: true,
        data: JSON.stringify({
            address: fieldAddress,
            cost: fieldCost,
            owner: {
                id: ownerId
            }
        }),
        headers: {
            //tells my application that it sends it on JSON
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (result) {
            console.log('LOG_result: ' + result)
            if (result) {
                alert("Field created successfully!")
            } else {
                alert("Some error!")
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};