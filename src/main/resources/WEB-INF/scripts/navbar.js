let url = new URL(window.location.href);
let params = new URLSearchParams(url.search);

let userId = params.get('id');

window.onload = function () {
   // alert("works")
    // restGetAll();
};

let goToFields = function () {
    window.location.href = 'fields.html?userId=' + userId;
};

let goToAddField = function () {
    window.location.href = 'fieldAdd.html?id=' + userId;
};

let goToMyFields = function () {
    window.location.href = 'showMyFields.html?id=' + userId;
};

let goToMyWallet = function () {
    window.location.href = 'Wallet.html?id=' + userId;
};
