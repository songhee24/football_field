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
        field => output += field.id + ', ' + field.address + ', ' + 'field.cost' + ', ' + 'field.owner.id ' + '<br>'
    );
    // $('#content-field').html(output);
    // $('#content-field2').html( JSON.stringify( data ) );
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

