var prefix = 'http://localhost:8080/';
var restGetFootballFieldById = function () {
    var id = $("input#id-value").val();
    console.log("id: " + id);

    $.ajax({
        type: 'GET',
        url: prefix + 'football/' +  id,
        dataType: 'json',
        async: true,
        success: function (result) {
            console.log(result);
            $(".hello-reaction").html('<h3>' + result.id + ', ' + result.address + ', ' + result.cost + '</h3>');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};
var restGetAll = function () {
    $.ajax({
        type: 'GET',
        url: prefix + 'football/getAll/',
        dataType: 'json',
        async: true,
        success: function (result) {
            console.log(result);
            var output = '';
            result.forEach(
                field => output += field.id + ', ' + field.address + ', ' + field.cost + ', ' + field.owner.name + '<br>'
            );
            $(".hello-reaction").html('<h3>' + output +'</h3>');
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};
var restSave = function () {

    var name = $("input#name-value").val();
    console.log('name: ' + name)

    // var city = {};
    // // city.id = null;
    // city.name = name;
    // console.log('TEST_city: ' + JSON.stringify(city))

    $.ajax({
        url: prefix,
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify({name:name}),
        headers: {
            //tells my application that it sends it on JSON
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        // async: true,
        success: function (result) {
            console.log(result);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log("ERROR: ");
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};
// function emptyIdField() {
//     document.getElementById("id-value").placeholder("");
// }
// function emptyIdNameField() {
//     document.getElementById("name-value").placeholder("");
// }
