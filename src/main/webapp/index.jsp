<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 4/27/2024
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="sharing.jsp"></jsp:include>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container mt-4">
    <form id="form-register" action="customer" method="post">
        <input type="hidden" name="action" value="register">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" class="form-control"  name="username" required value="${username}">
            <div class="rq err_username"> ${error_username} </div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" class="form-control" name="password" value="${password}" required>
            <div class="rq err_password"></div>
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" id="name" class="form-control"  name="name" value="${name}" required >
            <div class="rq err_name"></div>
        </div>
        <div class="mb-3">
            <label for="email_address" class="form-label">Email address</label>
            <input type="email" id="email_address" class="form-control" name="email_address" value="${email}" required>
            <div class="rq err_email"></div>
        </div>
        <div class="mb-3">
            <label for="number_phone" class="form-label">Number phone</label>
            <input type="text" id="number_phone" class="form-control"  name="number_phone" value="${phone}" required>
            <div class="rq err_phone"></div>
        </div>

        <button type="button" id="submit-register" class="btn btn-primary">Register</button>
    </form>

</div>
<script>
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
            error = true
            return;
        }else {
            err_username = document.getElementsByClassName("err_username")[0];
            err_username.innerHTML= "<span>  </span>"
            error = false;
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
            return;
        }else  if (!hasSpecialChar) {
            err_password = document.getElementsByClassName("err_password")[0];
            err_password.innerHTML= "<span> Mật khẩu phải có ít nhất 1 kí tự đặc biệt </span>"
            error = true;
            return;
        } else  if (!isValidLength) {
            err_password = document.getElementsByClassName("err_password")[0];
            err_password.innerHTML= "<span> Mật khẩu phải có ít nhất 8 kí tự</span>"
            error = true;
            return;
        } else {
            err_password = document.getElementsByClassName("err_password")[0];
            err_password.innerHTML= "<span></span>"
            error = false;
        }

        if(name.length < 3){
            err_name = document.getElementsByClassName("err_name")[0];
            err_name.innerHTML= "<span> Tên không hợp lệ </span>"
            error = true;
            return;
        }else {
            err_name = document.getElementsByClassName("err_name")[0];
            err_name.innerHTML= "<span></span>"
            error = false;
        }
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        var isValidEmail = emailRegex.test(email);
        if (!isValidEmail) {
            err_email = document.getElementsByClassName("err_email")[0];
            err_email.innerHTML= "<span> Email không hợp lệ </span>"
            error = true;
            return;
        }else {
            err_email = document.getElementsByClassName("err_email")[0];
            err_email.innerHTML= "<span></span>"
            error = false;
        }


        var phoneRegex = /^\d{10,}$/; // Biểu thức chính quy để kiểm tra số điện thoại, ở đây tôi giả sử số điện thoại có ít nhất 10 chữ số
        var isValidPhone = phoneRegex.test(number_phone);
        if (!isValidPhone) {
            err_phone = document.getElementsByClassName("err_phone")[0];
            err_phone.innerHTML= "<span> Số điện thoại không hợp lệ </span>"
            error = true;
            return;
        }else {
            err_phone = document.getElementsByClassName("err_phone")[0];
            err_phone.innerHTML= "<span></span>"
            error = false;
        }
        if(error == false){
            form_register.submit();
            console.log("da vao day")
        }else {
            console.log("da vao else")
            return;
        }

    }
</script>
\</body>
</html>
