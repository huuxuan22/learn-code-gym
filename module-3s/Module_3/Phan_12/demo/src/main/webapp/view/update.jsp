<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 22/02/2024
  Time: 12:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style>
    form {
      justify-content: center;

    }
    .centered-div {
      width: 300px; /* Đặt chiều rộng của div */
      height: 200px; /* Đặt chiều cao của div */
      background-color: lightblue; /* Đặt màu nền */
      margin: auto; /* Tự động căn giữa theo chiều ngang */
      padding: 20px; /* Thêm khoảng trống nội bộ */
      text-align: center; /* Căn giữa nội dung */
      border: 1px solid gray;
    }
  </style>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("id"));%>
<div class="centered-div">
  <form method="post" action="/user?action=update">
    <input type="hidden" name="idUpdate" value="<%=id%>">
    <label>Name: </label></br>
    <input type="text" name="name"></br>
    <label>Email: </label></br>
    <input type="text" name="email"></br>
    <label>Country: </label></br>
    <input type="text" name="country"></br>
    <button type="submit">Cập Nhật </button></br>
  </form>
</div>
</body>
</html>
