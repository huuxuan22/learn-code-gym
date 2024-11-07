<%--
  Created by IntelliJ IDEA.
  User: XUAN
  Date: 04/02/2024
  Time: 11:32 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</head>
<body>
<%--int idProduct, String nameProduct, int price, String producer--%>
<table class="table table-striped">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Giá cả</th>
        <th>Nhà Sản Xuất</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="status">
    <tr>
        <td>${product.getIdProduct()}</td>
        <td>${product.getNameProduct()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getProducer()}</td>
    </tr>
    </c:forEach>
</table>
<a href="/product?action=add">Thêm mới</a>
<%--<a href="/product?action=update">Chỉnh sửa sản phẩm</a>--%>
<a href="/product?action=delete">Xóa Sản phẩm</a>
<a href="/product?action=update">Chỉnh sửa sản phẩm</a>
</body>
</html>
