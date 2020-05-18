let prefix = "http://localhost:8080/";


function validatePassword() {
        //TODO fields must be required
        data = $('#password').val();
        var len = data.length;

        if (len < 1) {
            alert("Password cannot be blank");
            return false;
            // Prevent form submission
            // event.preventDefault();
        } else if ($('#password').val() !== $('#confirmPassword').val()) {
            alert("Password and Confirm Password don't match");
            return false;
            // Prevent form submission
            // event.preventDefault();
        }
    return true;
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

$(document).ready(function(){
    $(function() {
        $('#sub').click(function(e) {
            var username = $('#username').val();
            var email = $('#email').val();
            var password =  $('#password').val();
            var confirmPassword = $('#confirmPassword').val();

            console.log('password: ' + password);
            console.log('password confirm: ' + confirmPassword);

            if (validatePassword()) {
                e.preventDefault();
                $.ajax({
                    url: prefix + "customer/create",
                    dataType: 'json',
                    async: true,
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify({
                        fullName: username,
                        email: email,
                        password: password,
                        // TODO add to user his wallet
                        // balance: $('#бабки').val()
                        //FIXME можно же ведь сделать так ?
                        balance: 0
                        //FIXME вполне. Потом нужно добавить юзеру воображаемый wallet.
                    }),
                    processData: false,
                    success: function (data, result, textStatus, jQxhr) {
                        console.log(data);
                        console.log(result);
                        if (result == 'success') {
                            alert("You've been successfully registered");
                        }
                        // $('#response pre').html( JSON.stringify( data ) );
                    },
                    error: function (jqXhr, textStatus, errorThrown) {
                        console.log("ERROR: ");
                        console.log(jqXhr);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        });
    });
});
