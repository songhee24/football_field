let prefix = 'http://localhost:8080/';
window.onload = function() {
    console.log('works');
    // restGetAll();
    userAction();
};

const userAction = async () => {
    const response = await fetch(prefix + 'football/');
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);
    let output = '';
    let counter = 0;
    myJson.forEach(
        //TODO Can't find(understand) a template engine(Шаблонизатор) (ʘ‿ʘ)-fuck I spent three fucking hours
        field =>
            output
            += ((counter % 3 === 0)? '<hr>':'') +
            '<div class="container">'
                + '<div class="box">'
                    + '<div class="content">'
                            +'<h7>'+ field.id + '</h7>'
                            + '<h3>'+ field.address +'</h3>' + '<p>'
                            + field.cost + '</p>' + ''
                        +'<a href="bookingPage.html?id=' + field.id + '">select</a>'
                    + '</div>'
                + '</div>'
            + '</div>'
                + '<span class="hide-text">' + (counter++) + '</span>'

    );
    //<a href="bookingPage.html?id=' + field.id + '">select</a>
    // '<a href="http://localhost:8080/bookingPage.html?id=" + field.id>' + field.address + '</a>';
    $('#content-field').html(output);
    $('#content-field2').html( JSON.stringify( myJson ) );
};


// let restGetAll = function () {
//     $.ajax({
//         type: 'GET',
//         url: prefix + 'football/',
//         dataType: 'json',
//         async: true,
//         headers: {
//             //tells my application that it sends it on JSON
//             'Accept': 'application/json',
//             'Content-Type': 'application/json'
//         },
//         success: function (result) {
//             let output = '';
//             result.forEach(
//                 field => output += '<h2>' + field.id + '</h2>' +
//                     '<a href="bookingPage.html?id=' + field.id + '">' + '<h3>' + field.address + '</h3>' + '</a>'
//                     + '<p>' + field.cost + '</p>'
//             );
//             $('#content-field').html(JSON.stringify(output));
//             $("#content-field2").html('JSON: ' + JSON.stringify(result));
//
//         },
//         error: function (jqXHR, textStatus, errorThrown) {
//             console.log("ERROR: ");
//             console.log(jqXHR);
//             console.log(textStatus);
//             console.log(errorThrown);
//         }
//     });
// };

