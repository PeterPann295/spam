submit_register = document.getElementById("submit-register");
form_register = document.getElementById("form-register");
submit_register.onclick = () => {
    let error = false;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let name = document.getElementById("name").value;
    let email = document.getElementById("email_address").value;
    let number_phone = document.getElementById("number_phone").value;
    console.log("number phone :" + number_phone);
    if(username.length < 8) {
        err_username = document.getElementsByClassName("err_username")[0];
        err_username.innerHTML= "<span> Tên tài khoản phải ít nhất 8 kí tự </span>"
        error = true;
    }
    var uppercaseRegex = /[A-Z]/;
    var specialCharRegex = /[!@#$%^&*(),.?":{}|<>]/;
    var hasUppercase = uppercaseRegex.test(password);
    var hasSpecialChar = specialCharRegex.test(password);
    var isValidLength = password.length >= 8;
    if (!hasUppercase) {
        err_password = document.getElementsByClassName("err_password")[0];
        err_password.innerHTML= "<span> Mật khẩu phải có ít nhất 1 kí tự in hoa </span>"
        error = true;
    }

    if (!hasSpecialChar) {
        err_password = document.getElementsByClassName("err_password")[0];
        err_password.innerHTML= "<span> Mật khẩu phải có ít nhất 1 kí tự đặc biệt </span>"
        error = true;
    }

    if (!isValidLength) {
        err_password = document.getElementsByClassName("err_password")[0];
        err_password.innerHTML= "<span> Mật khẩu phải có ít nhất 8 kí tự</span>"
        error = true;
    }
    if(name.length < 3){
        err_name = document.getElementsByClassName("err_name")[0];
        err_name.innerHTML= "<span> Tên không hợp lệ </span>"
        error = true;
    }
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var isValidEmail = emailRegex.test(email);
    if (!isValidEmail) {
        err_email = document.getElementsByClassName("err_email")[0];
        err_email.innerHTML= "<span> Email không hợp lệ </span>"
        error = true;
    }

    var phoneRegex = /^\d{10,}$/; // Biểu thức chính quy để kiểm tra số điện thoại, ở đây tôi giả sử số điện thoại có ít nhất 10 chữ số
    var isValidPhone = phoneRegex.test(number_phone);
    if (!isValidPhone) {
        err_phone = document.getElementsByClassName("err_phone")[0];
        err_phone.innerHTML= "<span> Số điện thoại không hợp lệ </span>"
        error = true;
    }
    if(error == false){
        form_register.submit();
        console.log("da vao day")
    }else {
        console.log("da vao else")
        return;
    }

}