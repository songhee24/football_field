let prefix = 'http://localhost:8080/';

let url = new URL(window.location.href);
let params = new URLSearchParams(url.search);

let userId = params.get('id');

window.onload = function () {
    getFieldsByUserId()
};


//заменить на window.onload когда сможем получать userId автоматом
let getFieldsByUserId = function () {

    $.ajax({
        type: 'GET',
        url: prefix + 'football/getByOwnerId/' + userId,
        dataType: 'json',
        async: true,
        headers: {
            //tells my application that it sends it on JSON
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        success: function (result) {
            let output = '';
            result.forEach(
                field =>
                    output +=
                        '<p>id: ' + field.id + '</p>'
                    +   '<p>name: ' + field.address + '</p>'
                    +   '<p>cost: ' + field.cost + '</p><br>'
            );
            $('#fields-container').html(output);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};
let goToFieldAdd = function () {
    window.location.href = 'fieldAdd.html'
};