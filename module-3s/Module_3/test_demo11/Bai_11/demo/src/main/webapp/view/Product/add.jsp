<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 04/02/2024
  Time: 8:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</head>

<style>
  .form-label{
    width: 20%;
  }
  form{
    border: 1px solid black;

  }
</style>
<body>
<form method="post" >
  <label >Mã Sản phẩm</label></br>
  <input type="text" name="id"></br>
  <label> Tên sản phẩm</label></br>
  <input type="text" name="name"></br>
  <label>Giá cả</label></br>
  <input type="text" name="price"></br>
  <label>Nhà Sản xuất</label></br>
  <input type="text" name="producer"></br>
  <button type="submit">Lưu</button>
</form>
</body>
</html>
