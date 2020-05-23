let prefix = 'http://localhost:8080/';
let url = new URL(window.location.href);
let params = new URLSearchParams(url.search);

let userId = params.get('id');

window.onload = function () {
    // alert("works")
    getBalance();
};

let getBalance = async () => {
    const response = await fetch(prefix + 'wallet/' + userId);
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);

    let output = 'Balance: ' + myJson.balance + ' soms';

    $('#content-field').html(output);
};

let fillBalance = function () {

};
