var prefix = 'http://localhost:8080/';
window.onload = function() {
    console.log('works')
    // restGetAll();
    userAction();
};

const userAction = async () => {
    const response = await fetch(prefix + 'football/');
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);
    var output = '';
    myJson.forEach(
        field => output +='<div>' + field.id + ', ' +
            '<a href="bookingPage.html?id=' + field.id + '">' + field.address + '</a>'
            + ', ' + field.cost + ', ' + '</div><br>'
    );
    // '<a href="http://localhost:8080/bookingPage.html?id=" + field.id>' + field.address + '</a>';
    $('#content-field').html(output);
    $('#content-field2').html( JSON.stringify( myJson ) );
};
//
// var restGetAll = function () {
//     $.ajax({
//         type: 'GET',
//         url: prefix + 'football/',
//         dataType: 'json',
//         async: true,
//         success: function (result) {
//             console.log(result);
//             var output = '';
//             result.forEach(
//                 field => output += field.id + ', ' + field.address + ', ' + 'field.cost' + ', ' + 'field.owner.id ' + '<br>'
//             );
//             $('#content-field').html(output);
//             $('#content-field2').html('JSON: ' + JSON.stringify(result) );
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             console.log("ERROR: ");
//             console.log(jqXHR);
//             console.log(textStatus);
//             console.log(errorThrown);
//         }
//     });
// };

