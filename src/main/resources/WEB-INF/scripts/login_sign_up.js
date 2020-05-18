let prefix = "http://localhost:8080/";


function validatePassword() {
        //TODO fields must be required
        data = $('#password').val();
        var len = data.length;

        if (len < 1) {
            alert("Password cannot be blank");
            // Prevent form submission
            event.preventDefault();
        }

        if ($('#password').val() !== $('#confirmPassword').val()) {
            alert("Password and Confirm Password don't match");
            // Prevent form submission
            event.preventDefault();
        }
};

//хуйня не работает заебался
/*$(document).ready(function(){
    $('#signup-form').validate({
        rules:{
            username:{
                required: true,
                minlength: 4,
                maxlength: 16,
            },
            password:{
                required: true,
                minlength: 6,
                maxlength: 16,
            },
        },
        messages:{
            username:{
                required: "Это поле обязательно для заполнения",
                minlength: "Логин должен быть минимум 4 символа",
                maxlength: "Максимальное число символов - 16",
            },
            password:{
                required: "Это поле обязательно для заполнения",
                minlength: "Пароль должен быть минимум 6 символа",
                maxlength: "Пароль должен быть максимум 16 символов",
            },
        }
    });

});*/

var register = function () {
    $.ajax({
        url: prefix + 'create',
        dataType: 'json',
        async: true,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify( {
            fullName: $('#username').val(),
            email: $('#email').val(),
            password: $('#password').val(),
            // TODO add the user his wallet
            balance: $('#бабки').val()
        }),
        processData: false,
        success: function( data, result, textStatus, jQxhr ){
            console.log(data);
            console.log(result);
            // $('#response pre').html( JSON.stringify( data ) );
        },
        error: function( jqXhr, textStatus, errorThrown ){
            console.log("ERROR: ");
            console.log(jqXhr);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
};