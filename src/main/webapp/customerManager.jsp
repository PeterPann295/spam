
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customerDAO" scope="page" class="database.CustomerDao"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.datatables.net/v/bs5/dt-2.0.5/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/bs5/dt-2.0.5/datatables.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
    <script src="https://cdn.datatables.net/2.0.5/js/dataTables.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.5/css/dataTables.dataTables.css">
</head>
<body>
<h2> Đăng kí Thành Công </h2>
    <table table id="example" class="display" style="width:100%">
        <thead>
        <th> Username </th>
        <th> Name </th>
        <th> Email </th>
        <th> Phone </th>
        </thead>
        <c:forEach items="${customerDAO.selectAll()}" var="customer">
        <tr>
            <td> ${customer.username}</td>
            <td> ${customer.name} </td>
            <td> ${customer.email} </td>
            <td> ${customer.numberPhone} </td>
            <td> <button id="btn-delete" class="btn-delete" name="btn-delete" data-username="${customer.username}"> Delete  </button> </td>
        </tr
        </c:forEach>

    </table>
</body>
<script>
    $(document).ready(function() {
        $(".btn-delete").click(function() {
            var username = $(this).data("username");
            deleteUser(username);
        });
    });
    function deleteUser(username) {
        console.log("da vao ajax")
        $.ajax({
            url: "/customer?action=delete",
            type: "post",
            data: {
                username : username
            },
            success: function (response){
                if (response === "success") {
                    // Xóa thành công, loại bỏ phần tử HTML tương ứng
                    $(".btn-delete[data-username='" + username + "']").closest("tr").remove();
                    alert("Tài khoản đã được xóa thành công");
                } else {
                    // Xóa thất bại, hiển thị thông báo lỗi
                    alert("Đã xảy ra lỗi khi xóa tài khoản");
                }
            },
            error: function (xhr){

            }
        })
    }
</script>
</html>
